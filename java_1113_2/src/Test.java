import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Test {
    class Solution {
        //中序遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }
        //相同的树
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        //另一棵树的子树
        public boolean isSubtree(TreeNode s, TreeNode t) {
                if (s == null && t == null) {
                    return true;
                }
                if (s == null || t == null) {
                    return false;
                }
                boolean ret = false;
                //根节点相同判断数不是是同一棵树
                if (s.val == t.val) {
                    ret = isSameTree(s,t);
                }
                //左子树是否相同
                if (!ret) {
                    ret = isSubtree(s.left,t);
                }
                //右子树是否相同
                if (!ret) {
                    ret = isSubtree(s.right,t);
                }
                return  ret;
        }
        //二叉树的最大深度
        public int maxDepth(TreeNode root) {
            //空树
            if (root == null ) {
                return 0;
            }
            //只有一个节点
            if (root.left == null && root.right == null) {
                return 1;
            }
            //左子树或右子树的深度
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return 1 + (leftDepth > rightDepth ?
                    leftDepth : rightDepth );
        }
        //平衡二叉树
        //左右子树深度差小于等于1为平衡树
        public boolean isBalanced(TreeNode root) {
            if (root == null ) {
                return true;
            }
            //只有一个节点
            if (root.left == null && root.right == null) {
                return true;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            int depth = (leftDepth > rightDepth ?
                    leftDepth - rightDepth: rightDepth - leftDepth);
            if (depth <= 1) {
                return true;
            }
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        //对称二叉树
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            TreeNode t1 = root.left;
            TreeNode t2= root.right;
            return isMirror(t1,t2);
        }
        public boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        //制作一颗镜像树
        public TreeNode MakeMirror (TreeNode root) {
            if (root == null) {
                return null;
            }
            //交换左右子树
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            MakeMirror(root.left);
            MakeMirror(root.right);
            return root;
        }
        //层序遍历
        public void levelOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            List<Integer> list = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null ) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        //完全二叉树
//        public boolean isComplete(TreeNode root) {
//
//        }
    }
}
