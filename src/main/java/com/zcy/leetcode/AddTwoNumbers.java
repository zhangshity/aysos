package com.zcy.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:35 2018/11/28
 * @ Modified: By:
 * <p>
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 描述:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddTwoNumbers {
    /**
     * C语言链表节点定义:
     * struct ListNode {
     *     int val;    //定义val变量值，存储节点值
     *     struct ListNode *next;   //定义next指针，指向下一个节点，维持节点连接
     * }
     *
     * Java链表节点定义(无指针):
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


    //==========java中定义单链表===================================================
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { //利用constructor给变量赋值(getter、setter也可)
            val = x;
        }
    }


    //==========解决===================================================
    class Solution {

        ListNode listNode1 = new ListNode(2);
//        listNode.get

        //main
        //return:自定义单链表 ListNode，param:两个自定义链表listNode1 listNode2
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            return null;
        }
    }
}
