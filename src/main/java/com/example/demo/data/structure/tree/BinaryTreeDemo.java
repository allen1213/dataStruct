package com.example.demo.data.structure.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        TreeNode root = new TreeNode(1,"1");
        TreeNode node2 = new TreeNode(2,"2");
        TreeNode node3 = new TreeNode(3,"3");
        TreeNode node4 = new TreeNode(4,"4");
        TreeNode node5 = new TreeNode(5,"5");

        root.setLeft(node2).setRight(node3);
        node3.setLeft(node5).setRight(node4);
        binaryTree.setRoot(root);

        /*binaryTree.preOrder();
        System.out.println();
        binaryTree.infixOrder();
        System.out.println();
        binaryTree.postOrder();*/


        /*System.out.println(binaryTree.preOrderSearch(10));
        System.out.println(binaryTree.infixOrderSearch(20));
        System.out.println(binaryTree.postOrderSearch(4));*/
        binaryTree.preOrder();
        System.out.println();
        binaryTree.deleteNode(5);
        binaryTree.preOrder();
        System.out.println();


    }

}

class TreeNode {

    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public TreeNode setNo(int no) {
        this.no = no;
        return this;
    }

    public String getName() {
        return name;
    }

    public TreeNode setName(String name) {
        this.name = name;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
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

    public TreeNode preOrderSearch(int no) {
        if (this.getNo() == no) return this;

        TreeNode node = null;
        if (this.left != null) node = this.left.preOrderSearch(no);
        if (node != null) return node;

        if (this.right != null) node = this.right.preOrderSearch(no);

        return node;
    }

    public TreeNode infixOrderSearch(int no) {

        TreeNode node = null;
        if (this.left != null) node = this.left.infixOrderSearch(no);
        if (node != null) return node;

        if (this.getNo() == no) return this;

        if (this.right != null) node = this.right.infixOrderSearch(no);

        return node;
    }

    public TreeNode postOrderSearch(int no) {

        TreeNode node = null;
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

    public void delNode(int no) {
        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            if (this.getLeft().getLeft() != null) {
                this.setLeft(this.getLeft().getLeft());
                return;
            } else if (this.getLeft().getRight() != null) {
                this.setLeft(this.getLeft().getRight());
                return;
            } else {
                this.setLeft(null);
                return;
            }
        }

        if (this.getRight() != null && this.getRight().getNo() == no) {
            if (this.getRight().getLeft() != null) {
                this.setLeft(this.getRight().getLeft());
                return;
            } else if (this.getRight().getRight() != null) {
                this.setLeft(this.getRight().getRight());
                return;
            } else {
                this.setRight(null);
                return;
            }
        }

        if (this.getLeft() != null) this.getLeft().delNode(no);
        if (this.getRight() != null) this.getRight().delNode(no);

    }

}

class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BinaryTree setRoot(TreeNode root) {
        this.root = root;
        return this;
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

    public TreeNode preOrderSearch(int no) {
        if (root != null) return root.preOrderSearch(no);
        return null;
    }

    public TreeNode infixOrderSearch(int no) {
        if (root != null) return root.infixOrderSearch(no);
        return null;
    }

    public TreeNode postOrderSearch(int no) {
        if (root != null) return root.postOrderSearch(no);
        return null;
    }

    public void deleteNode(int no) {
        if (this.root == null) return;
        if (this.root.getNo() == no) {
            root = null;
            return;
        }
        root.deleteNode(no);
    }

    public void delNode(int no) {
        if (this.root == null) return;
        if (this.root.getNo() == no) {

        }
    }

}
