package com.zcy.tools.stop_watch;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class StopWatchForeachGuavaTest {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = Stopwatch.createStarted(); //创建后立即start，常用

        List<String> taskList = Arrays.asList("task1", "task2", "task3", "task4", "task5", "task6", "task7", "task8");
        for (String task : taskList) {
            doSomething(task);

            System.out.println(task + " , time: " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
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
