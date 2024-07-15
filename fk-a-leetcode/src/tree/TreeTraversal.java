package tree;


import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    /**
     *      5
     *     / \
     *    3   4
     *   / \
     *  8   1
     */

    public static void main(String[] args) {
        // 1.build tree
        Node root = new Node();
        root.setValue(5);
        Node left = new Node();
        Node subLeft = new Node();
        subLeft.setValue(8);
        Node subRight = new Node();
        subRight.setValue(1);
        left.setValue(3);
        left.setLeft(subLeft);
        left.setRight(subRight);
        Node right = new Node();
        right.setValue(4);
        root.setLeft(left);
        root.setRight(right);
        System.out.println(root);

        // 2.traverse tree
        System.out.println("前序遍历");
        preorderTraversal(root); //前序遍历

        System.out.println("中序遍历");
        inorderTraversal(root); //中序遍历

        System.out.println("后序遍历");
        postorderTraversal(root); //后序遍历

        System.out.println("广度优先遍历");
        BFS(root);

    }

    private static void BFS(Node root) {
        if (root == null) {
            return;
        }

        // 拿到队列中的一个节点: 1.处理值 2.并把左右节点加入队列

        Queue<Node> queue = new LinkedList<>(); // 构建队列
        queue.offer(root);                      // 队列放入根节点，作为开始
        while (!queue.isEmpty()) {
            // 1.处理值
            Node node = queue.poll();
            System.out.println(node.value);

            // 2.左右节点加入队列
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }


    public static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.getValue());
            preorderTraversal(root.getLeft());
            preorderTraversal(root.getRight());
        }
    }

    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.println(root.getValue());
            inorderTraversal(root.getRight());
        }
    }

    public static void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.getLeft());
            postorderTraversal(root.getRight());
            System.out.println(root.getValue());
        }
    }
}
