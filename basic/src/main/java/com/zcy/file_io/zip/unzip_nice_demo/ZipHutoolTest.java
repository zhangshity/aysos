package com.zcy.file_io.zip.unzip_nice_demo;

import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.zip.ZipInputStream;

public class ZipHutoolTest {
    public static void main(String[] args) throws IOException {
//        File unzip = ZipUtil.unzip("C:\\Users\\52576\\Desktop\\2022040001_img_20220601_20220601000199793173.zip", "C:\\Users\\52576\\Desktop", StandardCharsets.UTF_8);


//        ZipUtil
//        ZipUtil.getStream();
        ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(new File("C:\\Users\\52576\\Desktop\\2022040001_img_20220601_20220601000199793173.zip").toPath()));
        File unzip1 = ZipUtil.unzip(zipInputStream, new File("C:\\Users\\52576\\Desktop"));

    }
}
