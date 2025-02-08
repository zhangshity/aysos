package com.zcy.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 */
public class BinaryTree {

    /**
     * 二叉树节点定义
     */
    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
        }
    }


    // Main
    public static void main(String[] args) {
        /**
         * 构造二叉树
         *        1
         *       / \
         *      2   3
         *     / \ / \
         *    4  5 6  7
         */
        Node root = new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.right.left = new Node("6");
        root.right.right = new Node("7");


        // ---- DFS-深度优先遍历 (Depth-First Search) ----
        System.out.print("\n\n---- DFS-深度优先遍历 (Depth-First Search) ----");
        System.out.println("\nDFS-递归-前(根)序遍历");
        dfsPreorderTraversal(root); //1245367
        System.out.println("\nDFS-递归-中(根)序遍历");
        dfsInorderTraversal(root); //4251637
        System.out.println("\nDFS-递归-后(根)序遍历");
        dfsPostorderTraversal(root); //4526731
        System.out.println("\nDFS-栈");
        dfsStack(root); //1245367


        // ---- BFS-广度度优先遍历 (Breadth-First Search) ----
        System.out.print("\n\n---- BFS-广度度优先遍历 (Breadth-First Search) ----");
        System.out.println("\nBFS-队列");
        bfs(root); //1234567

    }


    // ------------------ 遍历二叉树 (DFS-递归) ------------------

    public static void dfsPreorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        // 根
        System.out.print(node.val);
        // 递归左
        dfsPreorderTraversal(node.left);
        // 递归右
        dfsPreorderTraversal(node.right);
    }

    public static void dfsInorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        // 递归左
        dfsInorderTraversal(node.left);
        // 根
        System.out.print(node.val);
        // 递归右
        dfsInorderTraversal(node.right);
    }

    public static void dfsPostorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        // 递归左
        dfsPostorderTraversal(node.left);
        // 递归右
        dfsPostorderTraversal(node.right);
        // 根
        System.out.print(node.val);
    }


    // --------- 遍历二叉树 (DFS-栈)---------

    public static void dfsStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            System.out.print(tmpNode.val);

            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
    }


    // --------- 遍历二叉树 (BFS队列)---------
    // 用示例树演示代码执行过程：
    //
    // 步骤	 队列状态   当前节点   输出	    新增入队节点
    // 1	 [1]	    1	    1   	2,3
    // 2	 [2,3]	    2	    2   	4,5
    // 3	 [3,4,5]    3	    3   	6
    // 4	 [4,5,6]    4	    4   	无
    // 5	 [5,6]	    5	    5   	无
    // 6	 [6]	    6	    6   	无
    // 最终输出：1 2 3 4 5 6

    public static void bfs(Node node) {
        if (node == null) return;          // 边界检查

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);                   // 初始化队列

        while (!queue.isEmpty()) {         // 只要队列不空就继续
            Node currentNode = queue.poll();  // 取出队首元素
            System.out.print(currentNode.val);

            // 将子节点加入队列（如果存在）
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    public static void bfs2(Node node, int level) {
        int currentLevel = 0;

        if (node == null || currentLevel != level) {
            return

                    ;
        }

        System.out.print(node.val);
        bfs2(node.left, level + 1);
        bfs2(node.right, level + 1);

    }


}
