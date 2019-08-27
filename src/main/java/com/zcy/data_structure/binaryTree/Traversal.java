package com.zcy.data_structure.binaryTree;

import com.zcy.data_structure.binaryTree.TreeNode;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>前序遍历二叉树</>
 * @ Date: Created in 15:15 2019/8/27
 * @ Modified: By:
 */
public class Traversal {

    //前序遍历
    public void preOrder(TreeNode tree) {
        System.out.print(tree.data + " ");

        TreeNode left = tree.liftNode;
        if (left != null) {
            preOrder(left);
        }

        TreeNode right = tree.rightNode;
        if (right != null) {
            preOrder(right);
        }
    }


    public void preOrder2(TreeNode node) {
        System.out.print(node.data);
        if (node.liftNode != null)
            preOrder2(node.liftNode);
        if (node.rightNode != null)
            preOrder2(node.rightNode);
    }

    //中序遍历
    public void inOrder(TreeNode node) {
        if (node.liftNode != null)
            inOrder(node.liftNode);
        System.out.print(node.data + " ");
        if (node.rightNode != null)
            inOrder(node.rightNode);
    }


    //后续遍历
    public void postOrder(TreeNode node) {

//        if (node == null) {
//        } else {
//            postOrder(node.liftNode);
//            postOrder(node.rightNode);
//            System.out.print(node.data);
//        }

        if (node != null) {
            postOrder(node.liftNode);
            postOrder(node.rightNode);
            System.out.print(node.data + " ");
        }


    }


}



