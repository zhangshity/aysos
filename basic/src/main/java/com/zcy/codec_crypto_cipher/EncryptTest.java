package com.zcy.codec_crypto_cipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Random;


class EncryptTest {

    static String data = "{\n" +
                         "\"msg\": \"SUCCESS\",\n" +
                         "\"code\": \"000000\",\n" +
                         "\"data\": {\n" +
                         "\"custNo\": \"中文20180425000001\"\n" +
                         "}\n" +
                         "}\n";


    public static void main(String[] args) {
        EncryptTest c = new EncryptTest();

        c.test_encryption_mechanisms();
    }


    void test_encryption_mechanisms() {
        try {
            /* ----------------生成秘钥对------------------ */
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(2048);

            //rsa生成 盈峰 公私钥对
            KeyPair yfphPair = gen.generateKeyPair();
            PublicKey yfph_pub = yfphPair.getPublic();
            PrivateKey yfph_pri = yfphPair.getPrivate();

            //rsa生成 合作方 公私钥对
            KeyPair appPair = gen.generateKeyPair();
            PublicKey app_pub = appPair.getPublic();
            PrivateKey app_pri = appPair.getPrivate();

            // DES 随机密码
            SecretKey desKey = genDESKey();

            /* -------------- 合作方加密  -->  盈峰 -------------------- */
            PackedBody enc = encrypt(data, desKey, yfph_pub, app_pri);
            System.out.println("------加密结果:------\n" + enc.toString());

            /* -------------- 盈峰解密 -------------------- */
            String dec = decrypt(enc, yfph_pri, app_pub);
            System.out.println("------解密结果:------\n" + dec);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    /**
     * 生成DES密码,注意:当前版本需要为ASCII可见字符作为密码
     *
     * @return
     * @throws Exception
     */
    private SecretKey genDESKey() throws Exception {
        // return KeyGenerator.getInstance("DES").generateKey(); !!!!!注意!!!!暂不支持这种方式
        int targetStringLength = 16;
        Random random = new Random();

        //随机生成16位可见字符密码, JDK8+
        String key = random.ints('0', 'z' + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(dks);
    }


    /**
     * 加密,用对方公钥加密,我方私钥加签
     *
     * @param raw
     * @param desKey
     * @param publicKey
     * @param privateKey
     * @return
     * @throws Exception
     */
    public PackedBody encrypt(String raw, SecretKey desKey, PublicKey publicKey, PrivateKey privateKey) throws Exception {
        PackedBody ret = new PackedBody();

        /* ------------- SHA1withRSA 算法进行签名 ------------------ */
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initSign(privateKey);

        byte[] rawBytes = raw.getBytes();
        //签名
        sign.update(rawBytes);
        byte[] signature = sign.sign();
        //转base64
        String sign_data = Base64.getEncoder().encodeToString(signature);
        ret.setSign_data(sign_data);

        /* ------------- RSA 加密 DES 秘钥------------------ */
        Cipher rsa_enc_cipher = Cipher.getInstance("RSA");
        // 用对方的公钥加密
        rsa_enc_cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] rsa_enc_Data = rsa_enc_cipher.doFinal(desKey.getEncoded());
        //转base64
        String encrypt_key = Base64.getEncoder().encodeToString(rsa_enc_Data);
        ret.setEncrypt_key(encrypt_key);

        /* ------------- DES 加密业务数据 ------------------ */
        Cipher des_enc_cipher = Cipher.getInstance("DES");
        des_enc_cipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] des_enc_Data = des_enc_cipher.doFinal(rawBytes);
        String seal_data = Base64.getEncoder().encodeToString(des_enc_Data);
        ret.setSeal_data(seal_data);

        return ret;
    }


    /**
     * 解密,用我方私钥解密,对方公钥验签
     *
     * @param body
     * @param privateKey
     * @param publicKey
     * @return
     * @throws Exception
     */
    public String decrypt(PackedBody body, PrivateKey privateKey, PublicKey publicKey) throws Exception {
        /* ------------- RSA 解密 DES 秘钥------------------ */
        //base64 解码
        byte[] decodedKey = Base64.getDecoder().decode(body.getEncrypt_key());
        // RSA 解密 DES 秘钥
        Cipher rsa_dec_cipher = Cipher.getInstance("RSA");
        // 用自己的私钥进行解密
        rsa_dec_cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedKey = rsa_dec_cipher.doFinal(decodedKey);
        //获取 DES 秘钥
        //SecretKey desKey = new SecretKeySpec(decryptedKey, 0, decryptedKey.length, "DES");
        DESKeySpec dks = new DESKeySpec(decryptedKey);
        SecretKey desKey = SecretKeyFactory.getInstance("DES").generateSecret(dks);


        /* ------------- DES 解密业务数据 ------------------ */
        byte[] decodedSealData = Base64.getDecoder().decode(body.getSeal_data());
        Cipher des_dec_cipher = Cipher.getInstance("DES");
        des_dec_cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] rawBytes = des_dec_cipher.doFinal(decodedSealData);
        String raw = new String(rawBytes, "UTF-8");

        /* ------------- 验签 ------------------ */
        Signature verifySign = Signature.getInstance("SHA1withRSA");
        verifySign.initVerify(publicKey);
        verifySign.update(rawBytes);

        byte[] signature = Base64.getDecoder().decode(body.getSign_data());
        if (!verifySign.verify(signature)) {
            throw new Exception("验签不通过!");
        }

        return raw;
    }


    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
}

class PackedBody {
    private String app_id;

    private String encrypt_key;

    private String seal_data;

    public String getSign_data() {
        return sign_data;
    }

    public void setSign_data(String sign_data) {
        this.sign_data = sign_data;
    }

    private String sign_data;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getEncrypt_key() {
        return encrypt_key;
    }

    public void setEncrypt_key(String encrypt_key) {
        this.encrypt_key = encrypt_key;
    }

    public String getSeal_data() {
        return seal_data;
    }

    public void setSeal_data(String seal_data) {
        this.seal_data = seal_data;
    }

    @Override
    public String toString() {
        return "{" +
               "\"app_id\":\"" + app_id + '\"' +
               ", \"encrypt_key\":\"" + encrypt_key + '\"' +
               ", \"seal_data\":\"" + seal_data + '\"' +
               ", \"sign_data\":\"" + sign_data + '\"' +
               '}';
    }
}
