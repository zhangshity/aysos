package com.zcy.tree;

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
        System.out.println("\n\n---- DFS-深度优先遍历 (Depth-First Search) ----");
        System.out.println("\n前(根)序遍历-DFS-递归");
        dfsPreorderTraversal(root); //1245367
        System.out.println("\n中(根)序遍历-DFS-递归");
        dfsInorderTraversal(root); //4251637
        System.out.println("\n后(根)序遍历-DFS-递归");
        dfsPostorderTraversal(root); //4526731


        // ---- BFS-广度度优先遍历 (Breadth-First Search) ----
        System.out.println("\n\n---- BFS-广度度优先遍历 (Breadth-First Search) ----");

    }


    // ------------------ 遍历二叉树 (递归) ------------------

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

    public static void bfsPreorderTraversal(Node node) {
//        Stack<Node> stack = new Stack<>();
//        stack.push(node);
//        Node node = stack.pop();


    }

    // --------- 遍历二叉树 (栈)---------

}
