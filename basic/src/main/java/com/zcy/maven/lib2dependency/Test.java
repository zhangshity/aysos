package com.zcy.maven.lib2dependency;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Element dependencys = new DOMElement("dependencys");
        File dir = new File("D:\\InforeWorkSpace\\amarsoft-console\\WebContent\\WEB-INF\\lib"); //lib目录

        int jar_num = 1;
        for (File jar : dir.listFiles()) {
            String jarname = jar.getName();
            System.out.println(jar_num + "\n" + jar.getName());
            jar_num++;


            int index = jarname.lastIndexOf("-");
            int jarIndex = jarname.lastIndexOf(".");
            if (index == -1 || jarIndex == -1) {
                System.out.println("");
                continue;
            }

            String bundleName = jarname.substring(0, index);
            String bundleVersion = jarname.substring(index + 1, jarIndex);


            System.out.println(getDependencies(bundleName, bundleVersion));
        }

    }

    public static String getDependencies(String key, String ver) {
        if (ver.equals("sources")) {
            return "";
        }
        String url = "https://maven.aliyun.com/artifact/aliyunMaven/searchArtifactByGav?groupId=&artifactId=" + key + "&version=" + ver + "&repoId=all&_input_charset=utf-8";

        org.jsoup.nodes.Document doc = null;

        try {
            doc = Jsoup.connect(url).ignoreContentType(true).timeout(60000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000L + new Random().nextInt(200));
        } catch (Exception e) {
        }

        org.jsoup.nodes.Element elem = doc.body();
        Object href1 = elem.childNodes().get(0);
        HashMap hashMap = JSON.parseObject(JSON.toJSONString(href1), HashMap.class);
        HashMap hashMap2 = JSON.parseObject(hashMap.get("wholeText").toString(), HashMap.class);
        String object = hashMap2.get("object").toString();
        List<Item> items = JSON.parseArray(object, Item.class);

        String groupId = null;
        for (Item item : items) {
            if ("jar".equals(item.getPackaging()) // jar
                && key.equals(item.getArtifactId()) // artifactId一致
                && ver.equals(item.getVersion()) // 版本一致
                && "central".equals(item.getRepositoryId()) // 中央仓库
                && item.getGroupId() != null // groupId不为空
                && !item.getGroupId().contains("#") && !item.getGroupId().contains("%")// 错误的groupId
            ) {
                groupId = item.getGroupId();
                break;
            }
        }

        if (groupId == null) {
            return "";
        }
        String result = "<dependency>\n" +
                        "    <groupId>" + groupId + "</groupId>\n" +
                        "    <artifactId>" + key + "</artifactId>\n" +
                        "    <version>" + ver + "</version>\n" +
                        "</dependency>\n";
        return result;
    }

    @Setter
    @Getter
    public static class Item {
        private String id;
        private String artifactId;
        private String classifier;
        private String fileName;
        private String groupId;
        private String packaging;
        private String repositoryId;
        private String version;
    }

}
