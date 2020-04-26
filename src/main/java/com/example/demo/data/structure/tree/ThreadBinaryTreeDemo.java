package com.example.demo.data.structure.tree;

public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        ThreadBinaryNode root = new ThreadBinaryNode(1, "1");
        ThreadBinaryNode node2 = new ThreadBinaryNode(3, "1");
        ThreadBinaryNode node3 = new ThreadBinaryNode(6, "1");
        ThreadBinaryNode node4 = new ThreadBinaryNode(8,"1");
        ThreadBinaryNode node5 = new ThreadBinaryNode(10, "1");
        ThreadBinaryNode node6 = new ThreadBinaryNode(14, "1");

        root.setRight(node2).setRight(node3);
        node2.setLeft(node4).setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.setRoot(root);

        tree.threadedNodes();
        System.out.println(node5.getLeft());

    }

}

class ThreadBinaryNode {
    private int no;
    private String name;
    private ThreadBinaryNode left;
    private ThreadBinaryNode right;

    private int leftType;
    private int rightType;

    public ThreadBinaryNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public ThreadBinaryNode setNo(int no) {
        this.no = no;
        return this;
    }

    public String getName() {
        return name;
    }

    public ThreadBinaryNode setName(String name) {
        this.name = name;
        return this;
    }

    public ThreadBinaryNode getLeft() {
        return left;
    }

    public ThreadBinaryNode setLeft(ThreadBinaryNode left) {
        this.left = left;
        return this;
    }

    public ThreadBinaryNode getRight() {
        return right;
    }

    public ThreadBinaryNode setRight(ThreadBinaryNode right) {
        this.right = right;
        return this;
    }

    public int getLeftType() {
        return leftType;
    }

    public ThreadBinaryNode setLeftType(int leftType) {
        this.leftType = leftType;
        return this;
    }

    public int getRightType() {
        return rightType;
    }

    public ThreadBinaryNode setRightType(int rightType) {
        this.rightType = rightType;
        return this;
    }

    @Override
    public String toString() {
        return "ThreadBinaryNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    public void postOrder() {
        if (this.left != null) this.left.postOrder();
        if (this.right != null) this.right.postOrder();
        System.out.println(this);
    }

    public ThreadBinaryNode preOrderSearch(int no) {
        if (this.getNo() == no) return this;

        ThreadBinaryNode node = null;
        if (this.left != null) node = this.left.preOrderSearch(no);
        if (node != null) return node;

        if (this.right != null) node = this.right.preOrderSearch(no);

        return node;
    }

    public ThreadBinaryNode infixOrderSearch(int no) {

        ThreadBinaryNode node = null;
        if (this.left != null) node = this.left.infixOrderSearch(no);
        if (node != null) return node;

        if (this.getNo() == no) return this;

        if (this.right != null) node = this.right.infixOrderSearch(no);

        return node;
    }

    public ThreadBinaryNode postOrderSearch(int no) {

        ThreadBinaryNode node = null;
        if (this.left != null) node = this.left.postOrderSearch(no);
        if (node != null) return node;

        if (this.right != null) node = this.right.postOrderSearch(no);
        if (node != null) return node;

        if (this.getNo() == no) return this;

        return null;
    }

    public void deleteNode(int no) {
        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            return;
        }
        if (this.getLeft() != null) this.getLeft().deleteNode(no);
        if (this.getRight() != null) this.getRight().deleteNode(no);
    }
}

class ThreadBinaryTree {
    private ThreadBinaryNode root;

    private ThreadBinaryNode preNode;

    public ThreadBinaryNode getRoot() {
        return root;
    }

    public ThreadBinaryTree setRoot(ThreadBinaryNode root) {
        this.root = root;
        return this;
    }

    public ThreadBinaryNode getPreNode() {
        return preNode;
    }

    public ThreadBinaryTree setPreNode(ThreadBinaryNode preNode) {
        this.preNode = preNode;
        return this;
    }

    public void showNodes() {
        ThreadBinaryNode node = root;
        while (node != null) {

            while (node.getLeftType() == 0)
                node = node.getLeft();

            System.out.println(node);

            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();

        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    private void threadedNodes(ThreadBinaryNode node) {
        if (node == null) return;

        threadedNodes(node.getLeft());

        //处理前驱节点
        if (node.getLeft() == null) {
            node.setLeft(preNode);
            node.setLeftType(1);
        }
        //处理后继节点
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        //最后将当前节点设置成前驱节点
        preNode = node;

        threadedNodes(node.getRight());
    }

    public void preOrder() {
        if (this.root != null) this.root.preOrder();
    }

    public void infixOrder() {
        if (this.root != null) this.root.infixOrder();
    }

    public void postOrder() {
        if (this.root != null) this.root.postOrder();
    }

    public ThreadBinaryNode preOrderSearch(int no) {
        if (root != null) return root.preOrderSearch(no);
        return null;
    }

    public ThreadBinaryNode infixOrderSearch(int no) {
        if (root != null) return root.infixOrderSearch(no);
        return null;
    }

    public ThreadBinaryNode postOrderSearch(int no) {
        if (root != null) return root.postOrderSearch(no);
        return null;
    }
}