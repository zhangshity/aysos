package com.zcy.codec_crypto_cipher.aes;

import javax.xml.bind.DatatypeConverter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加解密工具
 *
 * @author Allen.C.Y.Zhang
 * @since 2023-07-05
 */
public class CipherUtils {

    private CipherUtils() {
    }


    /**
     * AES加密
     *
     * @param key       秘钥
     * @param plaintext 明文
     * @return 密文
     */
    public static String aesEncrypt(String key, String plaintext) {
        try {
            // key
            byte[] keyBytes = generateAesKeyBytesBySeed(key);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // encrypt (10 -> 16)
            byte[] plaintextBytes = plaintext.getBytes();
            byte[] hexCiphertextBytes = cipher.doFinal(plaintextBytes);

            // encodeHex
            return DatatypeConverter.printHexBinary(hexCiphertextBytes);

        } catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AES解密
     *
     * @param key        秘钥
     * @param ciphertext 密文
     * @return 明文
     */
    public static String aesDecrypt(String key, String ciphertext) {
        try {
            // key
            byte[] keyBytes = generateAesKeyBytesBySeed(key);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            // decodeHex
            byte[] hexCiphertextBytes = DatatypeConverter.parseHexBinary(ciphertext);

            // decrypt (16 -> 10)
            byte[] plaintextBytes = cipher.doFinal(hexCiphertextBytes);
            return new String(plaintextBytes);

        } catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成AES秘钥
     *
     * @return AES秘钥
     */
    public static String generateAesKey() {
        try {
            // 生成AES秘钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); //位数: 128/192/256

            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();

            return DatatypeConverter.printHexBinary(encoded);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成AES秘钥 根据种子
     *
     * @param seed 种子
     * @return 秘钥
     */
    public static String generateAesKeyBySeed(String seed) {
        try {
            // 种子
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed.getBytes());

            // 生成AES秘钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, secureRandom); //位数: 128/192/256

            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();

            return DatatypeConverter.printHexBinary(encoded);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成AES秘钥 根据种子
     *
     * @param seed 种子
     * @return 秘钥
     */
    public static byte[] generateAesKeyBytesBySeed(String seed) {
        try {
            // 种子
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed.getBytes());

            // 生成AES秘钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, secureRandom); //位数: 128/192/256

            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println(generateAesKey());
        System.out.println(generateAesKeyBySeed("123456"));


        // ------- 加解密 -------
        String key = "123456";

        // 加密
        String plaintext = "hello124%as&^T^#|:q8KL";
        System.out.println("秘钥:" + key + " 明文:" + plaintext + " 密文:" + aesEncrypt(key, plaintext));

        // 解密
        String ciphertext = "B883C480C969AB040B81CDB127B6BD5AFA73671EB7FEC6FC3CBCE846C9BC22E3";
        System.out.println("秘钥:" + key + " 密文:" + ciphertext + " 明文:" + aesDecrypt(key, ciphertext));

    }

}