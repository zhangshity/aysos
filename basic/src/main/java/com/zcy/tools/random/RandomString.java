package com.zcy.tools.random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;

public class RandomString {

    public static void main(String[] args) {

        //char[] pairs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        //common-text方式
        char [][] pairs = {{'a','z'},{'A','Z'}};
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
        String randomLetters = generator.generate(20);
        System.out.println(randomLetters);

        //common-lang3方式
        String s = RandomStringUtils.randomAlphabetic(20);
        System.out.println(s);




    }
}
