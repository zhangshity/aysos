package com.zcy.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataXRegex {

    private static final Pattern VARIABLE_PATTERN = Pattern
            .compile("(\\$)\\{?(\\w+)\\}?");

    public static String replaceVariable(final String param) {
        Map<String, String> mapping = new HashMap<String, String>();

        Matcher matcher = VARIABLE_PATTERN.matcher(param);
        while (matcher.find()) {
            String variable = matcher.group(2);
            String value = System.getProperty(variable);
            if (StringUtils.isBlank(value)) {
                value = matcher.group();
            }
            mapping.put(matcher.group(), value);
        }

        String retString = param;
        for (final String key : mapping.keySet()) {
            retString = retString.replace(key, mapping.get(key));
        }

        return retString;
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"setting\": {},\n" +
                "    \"job\": {\n" +
                "        \"setting\": {\n" +
                "            \"speed\": {\n" +
                "                \"channel\": 2\n" +
                "            }\n" +
                "        },\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"reader\": {\n" +
                "                    \"name\": \"txtfilereader\",\n" +
                "                    \"parameter\": {\n" +
                "                        \"path\": [\"/home/haiwei.luo/case00/data\"],\n" +
                "                        \"encoding\": \"UTF-8\",\n" +
                "                        \"column\": [\n" +
                "                            {\n" +
                "                                \"index\": 0,\n" +
                "                                \"type\": \"long\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"index\": 1,\n" +
                "                                \"type\": \"boolean\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"index\": 2,\n" +
                "                                \"type\": \"double\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"index\": 3,\n" +
                "                                \"type\": \"string\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"index\": 4,\n" +
                "                                \"type\": \"date\",\n" +
                "                                \"format\": \"yyyy.MM.dd\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"fieldDelimiter\": \",\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"writer\": {\n" +
                "                    \"name\": \"txtfilewriter\",\n" +
                "                    \"parameter\": {\n" +
                "                        \"path\": \"/home/haiwei.luo/case00/result\",\n" +
                "                        \"fileName\": \"luohw\",\n" +
                "                        \"writeMode\": \"truncate\",\n" +
                "                        \"format\": \"yyyy-MM-dd\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        String s = replaceVariable(json);
        System.out.println(s);
    }
}
