import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
public class BinaryTree {
    private static TreeNode root = null;
    public static TreeNode build() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    public static void prevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }
    public static void inOder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOder(root.left);
        System.out.print(root.val);
        inOder(root.right);
    }
    public static void postOder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOder(root.left);
        postOder(root.right);
        System.out.print(root.val);
    }
//    public  static int treeSize = 0;
//    public  static void size(TreeNode root) {
//        if (root == null ){
//            return;
//        }
//        treeSize++;
//        size(root.left);
//        size(root.right);
//    }
    public  static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
//    public  static int leafSize = 0;
//        public  static void getLeafSize(TreeNode root) {
//        if (root == null ){
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            leafSize++;
//        }
//        getLeafSize(root.left);
//        getLeafSize(root.right);
//    }
    public  static int getLeafSize(TreeNode root) {
            if (root == null ){
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    public static int getKLevelSize(TreeNode root , int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
       return getKLevelSize(root.left,k - 1)
               + getKLevelSize(root.right , k - 1);
    }
    public static TreeNode find (TreeNode root , char tofind) {
        if (root == null) {
            return  null;
        }
        if (root.val == tofind) {
            return root;
        }
        TreeNode ret = find(root.left,tofind);
        if (ret != null) {
            return ret;
        }
        return find(root.right, tofind);
     }

    public static void main(String[] args) {
        root = build();
//        prevOrder(root);
//        System.out.println();
//        inOder(root);
//        System.out.println();
//        postOder(root);
//        System.out.println();
////        size(root);
////        System.out.println(treeSize);
//        System.out.println(getLeafSize(root));
//        System.out.println(getKLevelSize(root,3));
// //       System.out.println(leafSize);
//        System.out.println(size(root));
        System.out.println(find(root,'E'));
    }
}
