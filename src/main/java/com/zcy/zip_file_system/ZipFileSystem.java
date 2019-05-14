package com.zcy.zip_file_system;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: chunyang.zhang
 * @ Description: 压缩文件系统测试
 * @ Date: Created in 16:08 2019-05-13
 * @ Modified: By:
 */
public class ZipFileSystem {

    public void testMethod() {
//        Map<String, String> env = new HashMap<>();
//        env.put("create", "true");
//        Path path = Paths.get("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/test.zip");
//        URI uri = URI.create("jar:" + path.toUri());
//        try {
//            FileSystem fs = FileSystems.newFileSystem(uri, env);
//            Path nf = fs.getPath("/new.txt");
//            Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
//            writer.write("hello" + new Date());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //如果zip中有相同名称的文件,会自动替换
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        // locate file system by using the syntax
        // defined in java.net.JarURLConnection
//        URI uri = URI.create("jar:file:/codeSamples/zipfs/zipfstest.zip");
        Path path = Paths.get("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/test.zip");
//        Path path = Paths.get("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/resources.zip");

        URI uri = URI.create("jar:" + path.toUri());

        try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path externalTxtFile = Paths.get("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/record.txt");
            Path pathInZipfile = zipfs.getPath("/record_tt.txt");
            // copy a file into the zip file
            Files.copy(externalTxtFile, pathInZipfile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
