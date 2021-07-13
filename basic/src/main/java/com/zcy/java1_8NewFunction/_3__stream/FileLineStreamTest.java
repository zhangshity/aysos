package com.zcy.java1_8NewFunction._3__stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLineStreamTest {
    public static void main(String[] args) {
        //相对路径获取
        Path repoPath = Paths.get("basic", "src", "main", "resources", "io", "io.txt");
        //绝对路径获取
        Path absolutePath = Paths.get("/Users/zhangchunyang/Documents/IdeaProjects/aysos/basic/src/main/resources/io/io.txt");

        System.out.println("repoPath: " + repoPath);
        System.out.println("absolutePath: " + absolutePath);

        // 读取文件流
        try (Stream<String> lines = Files.lines(repoPath)) {
            lines.filter(l -> l.matches("\\d*"))
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
