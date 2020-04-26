package com.example.demo.data.structure.tree.binary.sort;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};//,0,2,4,6,11,13
        BinarySortTree tree = new BinarySortTree();

        for (int i : arr)  tree.addNode(new Node(i));

        tree.deleteNode(7);
        tree.deleteNode(3);
        tree.deleteNode(12);
        tree.deleteNode(5);
        tree.deleteNode(9);
        tree.deleteNode(10);
        tree.deleteNode(1);

        tree.infixOrder();
        System.out.println();
    }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return this.value + "  ";
    }

    public void addNode(Node node) {
        if (node == null) return;

        if (this.value > node.value) {
            if (this.left == null)
                this.left = node;
            else
                this.left.addNode(node);
        } else {
            if (this.right == null)
                this.right = node;
            else
                this.right.addNode(node);
        }
    }


    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.print(this);
        if (this.right != null) this.right.infixOrder();
    }

    //删除节点 首先要找到要删除的节点
    public Node getNode(int val) {

        if (this.value == val)
            return this;
        else if (this.value > val && this.left != null)
            return this.left.getNode(val);
        else if (this.value < val && this.right != null)
            return this.right.getNode(val);

        return null;
    }

    //删除节点  找到要删除的节点之后，要找到目标节点的父节点
    public Node getParentNode(int val) {

        if ((this.getLeft() != null && this.getLeft().getValue() == val) || (this.getRight() != null && this.getRight().getValue() == val))
            return this;

        else if (this.getValue() > val && this.getLeft() != null)
            return this.getLeft().getParentNode(val);

        else if (this.getValue() <= val && this.getRight() != null)
            return this.getRight().getParentNode(val);

        return null;

    }

}

class BinarySortTree {

    private Node root;

    public void addNode(Node node) {
        if (root == null) root = node;
        else root.addNode(node);
    }

    public void infixOrder() {
        if (root == null) return;
        root.infixOrder();
    }

    public Node getNode(int val) {
        if (root == null) return null;
        return root.getNode(val);
    }

    public Node getParentNode(int val) {
        if (root == null) return null;
        return root.getParentNode(val);
    }

    /**
     * 删除二叉排序树的节点
     * @param val
     */
    public void deleteNode(int val) {

        if (root == null) return;

        //若只有一个节点，直接删除
        if (root.getValue() == val && root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }
        //找到要删除的节点
        Node targetNode = getNode(val);
        if (targetNode == null) return;

        //找到待删除节点的父节点
        Node parentNode = getParentNode(val);

        //若待删除的节点是root节点，且有一个子节点的情况
        // 首先root节点没有parent ,然后判断root的值和传进来的值是否相等
        //最后判断root是只有左节点，还是只有右节点，把不为空的子节点作为root节点就可以了
        if (parentNode == null && root.getValue() == val && targetNode.getLeft() != null && targetNode.getRight() == null) {
            root = targetNode.getLeft();
            return;
        } else if (parentNode == null && root.getValue() == val && targetNode.getLeft() == null && targetNode.getRight() != null) {
            root = targetNode.getRight();
            return;
        }

        //如果要删除的节点是叶子节点
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {

            //判断targetNode是父节点的左节点还是右节点
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == val)
                parentNode.setLeft(null);
            else if (parentNode.getRight() != null && parentNode.getRight().getValue() == val)
                parentNode.setRight(null);


        } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {

            //找左子树的最大值或者右子树的最小值
            Node temp = targetNode.getLeft();
            while (temp.getRight() != null)
                temp = temp.getRight();

            //删除找到的最大值或者最小值,然后将改值赋值给找到的目标值
            // 到最后应该是一个叶子节点
            deleteNode(temp.getValue());
            targetNode.setValue(temp.getValue());

        } else {  //删除只有一个子节点的节点 ，且要删除的节点有父节点

            //首先根据父节点，判断要删除的节点是左节点还是右节点
            //然后在判断要删除节点只有左节点，还是只有右节点
            //最后将父节点的左节点或者右节点，设置成要删除节点的左节点或者右节点

            //待删除节点有父节点，并且在父节点的左边，要删除的节点left节点不为空，则将父节点的left置成目标节点的left
            if (parentNode.getLeft().getValue() == val && targetNode.getLeft() != null)
                parentNode.setLeft(targetNode.getLeft());
            //待删除节点有父节点，并且在父节点的左边，要删除的节点right节点不为空，则将父节点的left置成目标节点的right
            else if (parentNode.getLeft().getValue() == val && targetNode.getRight() != null)
                parentNode.setLeft(targetNode.getRight());

            //待删除节点有父节点，并且在父节点的右边，要删除的节点left节点不为空，则将父节点的right置成目标节点的left
            if (parentNode.getRight().getValue() == val && targetNode.getLeft() != null)
                parentNode.setRight(targetNode.getLeft());
            //待删除节点有父节点，并且在父节点的右边，要删除的节点right节点不为空，则将父节点的right置成目标节点的right
            else if (parentNode.getRight().getValue() == val && targetNode.getRight() != null)
                parentNode.setRight(targetNode.getRight());


        }


    }

}
