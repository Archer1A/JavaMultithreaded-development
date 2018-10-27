package IntroductionToAlgorithms;

/**
 * 二叉树Node节点
 */
public class TreeNode {
    private  int key ;
    private  int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int key, int data) {
        this.key = key;
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
