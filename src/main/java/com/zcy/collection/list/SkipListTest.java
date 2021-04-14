package com.zcy.collection.list;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * <p>跳表全称为跳跃列表，它允许快速查询，插入和删除一个有序连续元素的数据链表。
 * <p>
 * <p>跳跃列表的平均 查找 和 插入 [时间复杂度]都是 O(log n) 。[空间复杂度]为 O(n)
 * <p>
 * <p>* 快速查询是通过维护一个多层次的链表，且每一层链表中的元素是前一层链表元素的子集（见右边的示意图）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 跳表是用空间来换时间，跳表的效率比链表高了，但是跳表需要额外存储多级索引，所以需要的更多的内存空间。
 */
public class SkipListTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
    }
}
