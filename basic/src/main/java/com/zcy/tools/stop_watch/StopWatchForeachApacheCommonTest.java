package com.zcy.tools.stop_watch;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class StopWatchForeachApacheCommonTest {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = StopWatch.createStarted(); //创建后立即start，常用

        List<String> taskList = Arrays.asList("task1", "task2", "task3", "task4", "task5", "task6", "task7", "task8");
        for (String task : taskList) {
            sw.split();
            doSomething(task);

            System.out.println(task + " , time: " + (sw.getTime() - sw.getSplitTime()) + "ms");
        }
    }

    public static void doSomething(String task) {
        try {
            Thread.sleep(3200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
