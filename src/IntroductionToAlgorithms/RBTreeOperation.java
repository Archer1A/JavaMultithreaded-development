package IntroductionToAlgorithms;

import java.util.TreeMap;

/**
 * 红黑树的操作
 */
public class RBTreeOperation {
    public static void main(String[] args) {
        RbTree rbTreeNode = new RbTree();
//        rbTreeNode.RBInsert(new RBTreeNode(false,35,null,null,null));
//        rbTreeNode.RBInsert(new RBTreeNode(false,531,null,null,null));
//        rbTreeNode.RBInsert(new RBTreeNode(false,94,null,null,null));
        TreeMap<String, String> tree = new TreeMap<>();
        rbTreeNode.RBInsert(447);
        rbTreeNode.RBInsert(314);
        rbTreeNode.RBInsert(838);
        rbTreeNode.RBInsert(572);
    }
}
