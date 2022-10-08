package com.zcy.file_io.list;

import cn.hutool.core.io.resource.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class FileListTest {

    public static void main(String[] args) throws IOException, URISyntaxException {

        // IO绝对路径，获取文件
        System.out.println(Arrays.toString(new File("/").list())); // String
        System.out.println(Arrays.toString(new File("/").listFiles())); // File

        // NIO绝对路径，获取文件
        System.out.println(Files.list(Paths.get(new URI("file:/"))).map(Path::getFileName).collect(Collectors.toList()));
        System.out.println(Files.list(Paths.get(new URI("file:/"))).map(Path::toAbsolutePath).collect(Collectors.toList()));


        // Hutool项目相对路径，获取文件
        List<URL> resources = ResourceUtil.getResources("io/iosub1/");
        System.out.println(resources.stream().map(URL::getFile).collect(Collectors.toList()));
        System.out.println(resources.stream().map(URL::getPath).collect(Collectors.toList()));

        // JDK项目相对路径，获取文件
        Enumeration<URL> resources1 = FileListTest.class.getClassLoader().getResources("io/iosub1");
        URL resource = FileListTest.class.getClassLoader().getResource("io/iosub1");
        System.out.println(resource.getFile());
    }
}
