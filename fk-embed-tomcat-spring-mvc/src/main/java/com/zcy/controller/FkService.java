package com.zcy.controller;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FkService {
    public Map<String, String> getValue() {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("k1", "v1");
        stringStringHashMap.put("k2", "v2");

        stringStringHashMap.put("k3", "v3");
        stringStringHashMap.put("k4", "v4");


        return stringStringHashMap;

    }

}
