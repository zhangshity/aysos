package com.zcy.file_io.buffered_Reader_writer;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 边读边写
 */
public class ReadAndWrite {


    private String encrypt1(String sourcePath, String targetPath) {
//        String aesKey = baihangConfig.getAesKey();
//        String rsaPublicKey = baihangConfig.getRsaPublicKey();
        String aesKey = "baihangConfig.getAesKey()";
        String rsaPublicKey = "baihangConfig.getRsaPublicKey()";

        try {
            Path srcPath = Paths.get(sourcePath);
            Path tarPath = Paths.get(targetPath);

            // 校验
            if (!Files.exists(srcPath)) {
                throw new RuntimeException("待加密文件:" + sourcePath + "不存在！");
            }

            Files.createDirectories(tarPath.getParent()); // 创建缺失目录


            // 1.AES秘钥 RSA公钥加密写入
            byte[] aesKeyEncByte = RSAUtil.encryptData(rsaPublicKey, aesKey.getBytes());
            String aesKeyEnc = Base64.encodeBase64String(aesKeyEncByte) + "\n"; //单独一行
            Files.write(tarPath, aesKeyEnc.getBytes());

            // 2.数据 AES加密写入
            try (BufferedReader br = Files.newBufferedReader(srcPath);
                 BufferedWriter bw = Files.newBufferedWriter(tarPath, StandardOpenOption.APPEND)) {

                String line;
                while ((line = br.readLine()) != null) {

                    byte[] lineEncByte = AESUtil.encryptData(aesKey, line.getBytes());
                    String lineEnc = Base64.encodeBase64String(lineEncByte) + "\n";

                    bw.write(lineEnc);
                }
            }

            return targetPath;
        } catch (IOException e) {
            throw new RuntimeException("加密百行数据异常!", e);
        }
    }


    private String encrypt2(String sourcePath, String targetPath) {
//        String aesKey = baihangConfig.getAesKey();
//        String rsaPublicKey = baihangConfig.getRsaPublicKey();
        String aesKey = "baihangConfig.getAesKey()";
        String rsaPublicKey = "baihangConfig.getRsaPublicKey()";

        try {
            Path srcPath = Paths.get(sourcePath);
            Path tarPath = Paths.get(targetPath);

            // 校验
            if (!Files.exists(srcPath)) {
                throw new RuntimeException("待加密文件:" + sourcePath + "不存在！");
            }

            Files.createDirectories(tarPath.getParent()); // 创建缺失目录


            // 1.AES秘钥 RSA公钥加密写入
            byte[] aesKeyEncByte = RSAUtil.encryptData(rsaPublicKey, aesKey.getBytes());
            String aesKeyEnc = Base64.encodeBase64String(aesKeyEncByte) + "\n"; //单独一行
            Files.write(tarPath, aesKeyEnc.getBytes());

            // 2.数据 AES加密写入
            try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(srcPath)));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetPath, true)))) {

                String line;
                while ((line = br.readLine()) != null) {

                    byte[] lineEncByte = AESUtil.encryptData(aesKey, line.getBytes());
                    String lineEnc = Base64.encodeBase64String(lineEncByte) + "\n";

                    bw.write(lineEnc);
                }
            }

            return targetPath;
        } catch (IOException e) {
            throw new RuntimeException("加密百行数据异常!", e);
        }
    }


    private String encrypt3(String sourcePath, String targetPath) {
//        String aesKey = baihangConfig.getAesKey();
//        String rsaPublicKey = baihangConfig.getRsaPublicKey();
        String aesKey = "baihangConfig.getAesKey()";
        String rsaPublicKey = "baihangConfig.getRsaPublicKey()";

        try {
            Path srcPath = Paths.get(sourcePath);
            Path tarPath = Paths.get(targetPath);

            // 校验
            if (!Files.exists(srcPath)) {
                throw new RuntimeException("待加密文件:" + sourcePath + "不存在！");
            }

            Files.createDirectories(tarPath.getParent()); // 创建缺失目录


            // 1.AES秘钥 RSA公钥加密写入
            byte[] aesKeyEncByte = RSAUtil.encryptData(rsaPublicKey, aesKey.getBytes());
            String aesKeyEnc = Base64.encodeBase64String(aesKeyEncByte) + "\n"; //单独一行
            Files.write(tarPath, aesKeyEnc.getBytes());

            // 2.数据 AES加密写入
            try (InputStream is = Files.newInputStream(srcPath);
                 OutputStream os = Files.newOutputStream(tarPath, StandardOpenOption.APPEND);) {

                byte[] buf = new byte[8192];
                int n;
                while ((n = is.read(buf)) > 0) {

                    byte[] lineEncByte = AESUtil.encryptData(aesKey, buf);
                    String lineEnc = Base64.encodeBase64String(lineEncByte) + "\n";

                    os.write(lineEnc.getBytes(), 0, n);
                }
            }

            return targetPath;
        } catch (IOException e) {
            throw new RuntimeException("加密百行数据异常!", e);
        }
    }








    /**
     * Mock
     */
    public static class AESUtil {
        public static synchronized byte[] encryptData(String aesKey, byte[] data) {
            //initEncryptCipher(aesKey);
            //return encryptCipher.doFinal(data);
            return new byte[]{};
        }
    }

    /**
     * Mock
     */
    public static class RSAUtil {
        public static synchronized byte[] encryptData(String rsaKey, byte[] dataToEncrypt) {
            //initPublicKey(rsaKey);
            //return encryptCipher.doFinal(dataToEncrypt);
            return new byte[]{};
        }
    }


}
