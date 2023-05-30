package com.zcy.collection.map;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class EnumMapTest {
    public static void main(String[] args) {
        Map<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        Map<DayOfWeek, String> map = Collections.unmodifiableMap(enumMap);


        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map); //{MONDAY=星期一, TUESDAY=星期二, WEDNESDAY=星期三, THURSDAY=星期四, FRIDAY=星期五, SATURDAY=星期六, SUNDAY=星期日}

        System.out.println(map.get(DayOfWeek.MONDAY)); //星期一
    }
}
