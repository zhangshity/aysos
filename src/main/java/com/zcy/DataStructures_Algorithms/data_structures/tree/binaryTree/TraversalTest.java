package com.zcy.DataStructures_Algorithms.data_structures.tree.binaryTree;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 17:00 2019/8/27
 * @ Modified: By:
 * <p>      三层满二叉树:
 * <p>
 * <p>           1
 * <p>       2       3
 * <p>    4    5   6   7
 */
public class TraversalTest {


    public static void main(String[] args) {

        //构造3层满二叉树
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode21 = new TreeNode();
        TreeNode treeNode22 = new TreeNode();
        TreeNode treeNode31 = new TreeNode();
        TreeNode treeNode32 = new TreeNode();
        TreeNode treeNode33 = new TreeNode();
        TreeNode treeNode34 = new TreeNode();

        //数据填充
        treeNode1.data = 1;
        treeNode21.data = 2;
        treeNode22.data = 3;
        treeNode31.data = 4;
        treeNode32.data = 5;
        treeNode33.data = 6;
        treeNode34.data = 7;

        //结构连接
        treeNode1.liftNode = treeNode21;
        treeNode1.rightNode = treeNode22;
        treeNode21.liftNode = treeNode31;
        treeNode21.rightNode = treeNode32;
        treeNode22.liftNode = treeNode33;
        treeNode22.rightNode = treeNode34;

        System.out.println("二叉树节点值: " + treeNode1.data + treeNode21.data + treeNode22.data + treeNode31.data + treeNode32.data + treeNode33.data + treeNode34.data);

        //测试遍历方法是否正确==============
        //前序: 1 2 4 5 3 6 7
        //中序: 4 2 5 1 6 3 7
        //后续: 4 5 2 6 7 3 1

        Traversal traversal = new Traversal();

        System.out.println("前序遍历:");
        traversal.preOrder(treeNode1);

        System.out.println("\n中序遍历:");
        traversal.inOrder(treeNode1);

        System.out.println("\n后续遍历:");
        traversal.postOrder(treeNode1);

    }
}
