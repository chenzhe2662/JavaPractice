import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeDemo {
    //层序遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ) {
            return new ArrayList<>();
        }
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root,int leval) {
        if (leval == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(leval).add(root.val);
        if (root.left != null) {
            helper(root.left,leval + 1);
        }
        if (root.right != null) {
            helper(root.right,leval + 1);
        }
    }
    //二叉树的最近公共祖先
    private  TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root , p ,q);
        return lca;
    }
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //从根节点开始出现三种情况：
        //左子树找到
        //右子树找到
        //根节点就是祖先
        int left = findNode(root.left,p,q) ? 1:0;
        int right = findNode(root.right,p,q) ? 1:0;
        int mid = (root == p|| root == q) ? 1:0;
        if (left + right + mid >= 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    public static void main(String[] args) {
        TreeBulidDemo treeBulidDemo = new TreeBulidDemo();
        TreeDemo treeDemo = new TreeDemo();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeBulidDemo.TreeNode root = TreeBulidDemo.buildTree(line);
            TreeBulidDemo.inOrder(root);
            TreeNode p = new TreeNode(3);
            TreeNode q = new TreeNode(4);
            //treeDemo.lowestCommonAncestor(root,p,q);
            System.out.println();
        }
    }
}
