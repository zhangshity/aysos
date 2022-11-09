package com.zcy.file_io.zip;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class UnzipTest {

    public static void main(String[] args) {
        UnzipTest test = new UnzipTest();
//        test.unzip1("C:\\Users\\52576\\Desktop\\广东盈峰普惠互联小额贷款股份有限公司_D2_20220430_0001_inputerror.zip",
//                "C:\\Users\\52576\\Desktop");
        test.unzip2("C:\\Users\\52576\\Desktop\\广东盈峰普惠互联小额贷款股份有限公司_D2_20220430_0001_inputerror.zip",
                "C:\\Users\\52576\\Desktop");
    }


    private void unzip1(String sourceFilePath, String targetDirPath) {
        try (ZipFile zipFile = new ZipFile(sourceFilePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();

                // 子文件名
                String subFileName = zipEntry.getName();

                // 子文件
                InputStream inputStream = zipFile.getInputStream(zipEntry);

                Path path = Paths.get(targetDirPath, subFileName);
                Files.deleteIfExists(path);
                Files.createDirectories(path.getParent());
                Files.copy(inputStream, path);
            }

        } catch (Exception e) {
            throw new RuntimeException("解压:" + sourceFilePath + "异常", e);
        }
    }

    private void unzip2(String sourceFilePath, String targetDirPath) {
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(sourceFilePath)))) {
            ZipEntry zipEntry;
            while (( zipEntry = zis.getNextEntry())!=null){

                // 子文件名
                String subFileName = zipEntry.getName();

                // 子文件
                Path path = Paths.get(targetDirPath, subFileName);
                Files.deleteIfExists(path);
                Files.createDirectories(path.getParent());
                Files.copy(zis, path);
            }
        } catch (Exception e) {
            throw new RuntimeException("解压:" + sourceFilePath + "异常", e);
        }

    }


}
