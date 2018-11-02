package IntroductionToAlgorithms;

/**
 * 红黑树的操作
 */
public class RBTreeOperation {

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
}
