package IntroductionToAlgorithms;

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
}
