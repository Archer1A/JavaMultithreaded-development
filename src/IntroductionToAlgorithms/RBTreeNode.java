package IntroductionToAlgorithms;

import java.util.TreeMap;

public class RBTreeNode {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private boolean color ;
    private int key;
    private RBTreeNode left;
    private RBTreeNode right;
    private RBTreeNode parent;

    public static boolean isRED() {
        return RED;
    }

    public static boolean isBLACK() {
        return BLACK;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    public RBTreeNode(boolean color, int key, RBTreeNode left, RBTreeNode right, RBTreeNode parent) {

        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    // 假设 node.getRight != null, 且根节点的父节点为null
    public void leftRotate( RBTreeNode node) {
        RBTreeNode y = node.getRight();  // y设为node的右节点
        node.setRight(y.getLeft());//y的左子树放入node的右子树
        if (y.getLeft() != null) {
            y.getLeft().setParent(node);
        }
        y.setParent(node.getParent());
        if (node.getParent() != null && node == node.getParent().getLeft()) {
            node.getParent().setLeft(y);
        } else if (node.getParent() != null && node == node.getParent().getRight()) {
            node.getParent().setRight(y);
        }
        y.setLeft(node);
        node.setParent(y);
    }


    // 右旋转 假设node.getleft != null  且根节点的父节点为null
    public void rightRotate(RBTreeNode x) {
        RBTreeNode y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != null) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() != null && x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        }else  if (x.getParent() != null && x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        }
        y.setRight(x);
        x.setParent(y);
    }
    public void RBInsert(RBTreeNode tree,RBTreeNode z) {
        RBTreeNode y = null;
        RBTreeNode x = tree;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            }else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            tree.setKey(z.getKey());
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        }else {
            y.setRight(z);
        }
        z.setRight(null);
        z.setLeft(null);
        z.setColor(RED);
        RBInsertFixUp(tree, z);

    }

    private void RBInsertFixUp(RBTreeNode  tree,RBTreeNode z){
        while (z != null&& z.getParent() != null&&z.parent.color == RED) {
            if (z.getParent() == z.getParent().getParent().getLeft()){
                RBTreeNode y = z.getParent().getParent().getRight();
                if (y.color == RED) {              // 情况1
                    z.getParent().color = BLACK;
                    y.color = BLACK;
                    z.getParent().getParent().color = RED;
                    z = z.getParent().getParent();
                } else {

                    if (z == z.getRight()) {
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().color = BLACK;
                    z.getParent().getParent().color = RED;
                    rightRotate(z.getParent().getParent());
                }



            }else {
                RBTreeNode y = z.getParent().getParent().getLeft();
                if (y.color ==RED){
                    z.getParent().color = BLACK;
                    y.color = BLACK;
                    z.getParent().getParent().color = RED;
                    z = z.getParent().getParent();
                }else {
                    if (z == z.getParent().getLeft()) {
                        z = z.getParent();
                        rightRotate(z);
                    }
                    z.getParent().color = BLACK;
                    z.getParent().getParent().color = RED;
                    leftRotate(z.getParent().getParent());
                }
            }
        }
        tree.color = BLACK;
    }

}
