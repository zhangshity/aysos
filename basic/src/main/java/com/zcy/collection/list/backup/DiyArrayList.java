package com.zcy.collection.list.backup;

import java.util.ArrayList;
import java.util.List;

public class DiyArrayList {


    public long shulie(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n >= 4) {
            List list = new ArrayList();
            list.add(0, 1);
            list.add(1, 1);
            list.add(2, 2);
            for (int i = 3; i <= n; i++) {
                list.add(i, (int) list.get(i - 2) + (int) list.get(i - 1));
            }
            return (int) list.get(n - 1);
        }
        throw new RuntimeException("参数错误");
    }


    public static void main(String[] args) {
        DiyArrayList test = new DiyArrayList();
        System.out.println(test.shulie(6));

    }
}
