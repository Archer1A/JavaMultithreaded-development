package IntroductionToAlgorithms;

import java.util.HashMap;

public class SearchBinaryTree {
    public static TreeNode tree;
  //  private  static  TreeNode root;
    /*public  static  TreeNode put(int data){
        TreeNode node = null;
        TreeNode parent = null;
        if(root == null){
            node = new TreeNode(0, data);
            root = node;
            return node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data <node.getData()){
                node = node.getLeft();
            } else if (data > node.getData()) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        node = new TreeNode(0, data);
        if (data < parent.getData()) {
            parent.setLeft( node);
            node.setParent(parent);
        }else {
            parent.setRight(node);
            node.setParent(parent);
        }
        return node;
    }*/

    public static void midOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        midOrder(node.getLeft());
        System.out.println("当前节点为：" + node.getData());
        midOrder(node.getRight());
    }

    /**
     * 往搜索二叉树中插入节点
     * @param z
     */
    public static void treeInsert(TreeNode z){
        TreeNode y = null;
        TreeNode x = tree;
        while (x != null) {
            y = x;
            if (z.getData()< x.getData()){
                x = x.getLeft();
            }else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {

            tree = z;
        } else if (z.getData() < y.getData()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode();
        int[] arrs = new int[]{6,1,3,6,13,8,9,5,11,12};
        for (int arr : arrs){
            TreeNode node = new TreeNode(1, arr);
            treeInsert(node);
        }
        midOrder(tree);

      //  HashMap
    }
}
