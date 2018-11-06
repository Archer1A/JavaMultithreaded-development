package IntroductionToAlgorithms;

import java.util.TreeMap;

public class RbTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private Entry root;

    // 假设 node.getRight != null, 且根节点的父节点为null
    public void leftRotate( Entry node) {
        Entry y = node.getRight();  // y设为node的右节点
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
    public void rightRotate(Entry x) {
        Entry y = x.getLeft();
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

    public void RBInsert(int value) {
        Entry z = new Entry(value);
        Entry y = null;
        Entry x = root;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            root = new Entry(z.getKey());
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        z.setRight(null);
        z.setLeft(null);
        z.setColor(RED);
        RBInsertFixUp(z);

    }

    private static boolean colorOf(Entry node) {
        return (node == null? BLACK:node.color);
    }


    /**
     * 修复的3中情况
     * case 1 ： 当前节点的父节点是红色，且叔叔节点也是红色
     * case 2 ： 当前节点是红色，叔叔节点是黑色。当前节点是父节点的右子
     * case 3 ： 当前节点的父节点是红色，叔叔节点是黑色，当前节点是其父节点的左子
     * @param z
     */
    private void RBInsertFixUp(Entry z){
        while (z != null&& z.getParent() != null&&z.parent.color == RED) {  // z 不为空，且不为根节点，父节点为红色
            if (z.getParent() == z.getParent().getParent().getLeft()){  // 若父节点是左节点
                Entry y = z.getParent().getParent().getRight(); //叔叔节点y // case1
                if (colorOf(y) == RED) {              // 情况1  // 叔叔节点也为红色 // case1
                    z.getParent().color = BLACK;     // 将父节点和叔叔节点都染成黑色 // case1
                    y.color = BLACK;
                    z.getParent().getParent().color = RED; // 祖父节点染成红色       // case1
                    z = z.getParent().getParent();  // 以祖父节点为根节点的红黑树平衡，但祖父节点可能存在问题  // case1
                } else {

                    if (z == z.getParent().getRight()) { // 若叔叔节点为黑色，且父节点为右节点 //case 2
                        z = z.getParent();     // case 2
                        leftRotate(z);  //父节点左旋  // case 2
                    }
                    z.getParent().color = BLACK;  //case 3
                    z.getParent().getParent().color = RED; // case 3
                    rightRotate(z.getParent().getParent()); //case 3
                }



            }else {
                Entry y = z.getParent().getParent().getLeft();
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
        root.color = BLACK;
    }

    static final class Entry {


        private boolean color ;
        private int key;
        private Entry left;
        private Entry right;
        private Entry parent;

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

        public Entry getLeft() {
            return left;
        }

        public void setLeft(Entry left) {
            this.left = left;
        }

        public Entry getRight() {
            return right;
        }

        public void setRight(Entry right) {
            this.right = right;
        }

        public Entry getParent() {
            return parent;
        }

        public void setParent(Entry parent) {
            this.parent = parent;
        }

        public Entry(int key) {

            this.color = RED;
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }


}


}
