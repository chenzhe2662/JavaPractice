import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//创建二叉树abc##de#g##f###

public class TreeBulidDemo {
    static  class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = buildTree(line);
            inOrder(root);
            System.out.println();
        }
    }
    static  int index = 0;
    public static TreeNode buildTree(String line) {
        index = 0;
        return createTreePreOrder(line);
    }
    public static TreeNode createTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
