package com.example.fkreadspringbootresource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

@Service
public class TestService {

    private static final String path = "templates/datax/reader/readerPlugin.json";
    private static final String only_path = "templates/datax";


    @Autowired
    private ResourceLoader resourceLoader;

    public void test() throws IOException {

        // 1.
//        Resource resource = resourceLoader.getResource(path);
//        File file = resource.getFile();
//        String filename = resource.getFilename();
//        System.out.println(file + "\n" + filename );

//        Resource resource = resourceLoader.getResource(only_path);
//        File file = resource.getFile();
//        String filename = resource.getFilename();
//        System.out.println(file + "\n" + filename );
//
//        System.out.println(Arrays.toString(file.list()));

        ClassPathResource classPathResource = new ClassPathResource(only_path);
        System.out.println(classPathResource.getPath());

    }


}
