package com.zcy.file_io.zip.unzip_nice_demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamUnipDemo2 {

    public static void main(String args[]) throws Exception {

        byte[] buffer = new byte[2048];

        String zipFileName = "C:\\Users\\52576\\Desktop\\2022040001_img_20220601_20220601000199793173.zip";
        Path outDir = Paths.get("C:\\Users\\52576\\Desktop");

        try (FileInputStream fis = new FileInputStream(zipFileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ZipInputStream stream = new ZipInputStream(bis)) {

            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {

                Path filePath = outDir.resolve(entry.getName());

                try (FileOutputStream fos = new FileOutputStream(filePath.toFile());
                     BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {

                    int len;
                    while ((len = stream.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}