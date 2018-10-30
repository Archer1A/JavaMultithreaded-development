package IntroductionToAlgorithms;

import java.util.HashMap;

public class SearchBinaryTree {
  //  public static TreeNode tree;
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
    public static void treeInsert(TreeNode tree,TreeNode z){
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
            tree.setData(z.getData());
        } else if (z.getData() < y.getData()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }
    //递归的方式查找
    public TreeNode treeSearch(TreeNode tree, int x) {
        if (tree == null || tree.getKey() == x){
            return tree;
        }
        if (x < tree.getKey()) {
            return treeSearch(tree.getLeft(),x);
        }else {
            return treeSearch(tree.getRight(), x);
        }
    }



    // while 循环查找
    public static TreeNode iterativeTreeSearch(TreeNode tree, int x) {
        while (tree != null && x != tree.getData()) {
            if (x < tree.getData()) {
                tree = tree.getLeft();
            }else {
                tree = tree.getRight();
            }
        }
        return  tree;
    }


    //最小值
    public static TreeNode TreeMinimum(TreeNode tree) {
        while (tree.getLeft() != null) {
            tree = tree.getLeft();
        }
        return tree;
    }

    //最小值
    public static TreeNode TreeMaximum(TreeNode tree) {
        while (tree.getRight() != null) {
            tree = tree.getRight();
        }
        return tree;
    }

    //后继
    public static TreeNode treeSuccessor(TreeNode node) {
        if (node.getRight() != null) {  //如果该节点存在的右子树非空，则后继为右子树的最左节点
            return TreeMinimum(node.getRight());
        }
        TreeNode y = node.getParent();
        while (y != null && node == y.getRight()){
            node = y;
            y = y.getParent();
        }
        return y;
    }

    /**
     * 用另外一颗子树替换一颗子树并成为其双亲的子节点
     * @param tree
     * @param u 将被移除的节点
     * @param v u的孩子节点
     * @return
     */
    public  static void transplant(TreeNode tree, TreeNode u, TreeNode v) {
        if (u.getParent() == null&& v!=null) {  // 如果u是根节点
            tree.setData(v.getData());
            tree.setLeft(v.getLeft());
            tree.setRight(v.getRight());
        }else if(u == u.getParent().getLeft()){
            u.getParent().setLeft(v);
        }else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }
    public static void treeDelete (TreeNode tree,TreeNode z){
        if (z.getLeft() == null) {
            transplant(tree, z, z.getRight());
        } else if (z.getRight() == null) {
            transplant(tree,z,z.getRight());
        }else {
            TreeNode y = TreeMinimum(z.getRight());
            if (y.getParent()!= z){
                transplant(tree,y,y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            transplant(tree,z,y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{30,20,35,34,32,40,80,70,75,100};
        TreeNode tree = new TreeNode(1,50);
        for (int arr : arrs){
            TreeNode node = new TreeNode(1, arr);
            treeInsert(tree,node);
        }
        TreeNode l = iterativeTreeSearch(tree,100);
        treeDelete(tree,l);
        midOrder(tree);

      //  HashMap
    }
}
