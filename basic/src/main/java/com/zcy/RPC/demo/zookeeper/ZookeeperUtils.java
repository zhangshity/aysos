package com.zcy.RPC.demo.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ Author: chunyang.zhang
 * @ Description:《zookeeper的连接工具》
 * @ Date: Created in 14:53 2019-08-14
 * @ Modified: By:
 */
public class ZookeeperUtils {

    private static ZooKeeper zooKeeper = null;

    public static ZooKeeper connect() throws IOException, InterruptedException {
        //倒计时栓
        CountDownLatch latch = new CountDownLatch(1);
        //连接zk (String connectString,int sessionTimeout,Watcher watcher)
        zooKeeper = new ZooKeeper("localhost:2182", 60000, watchedEvent -> {
            if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                latch.countDown();
            }
        });
        //无连接阻碍
        latch.await();
        return zooKeeper;
    }


}
