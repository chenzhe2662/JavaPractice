package java_1115;

import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
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
    private static TreeNode build() {
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
    //先序遍历
    private static void prevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //中序遍历
    private static void inOder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOder(root.left);
        System.out.print(root.val);
        inOder(root.right);
    }
    //后序遍历
    private static void postOder(TreeNode root) {
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
    //求叶子节点
    private static int size(TreeNode root) {
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

    private static int getLeafSize(TreeNode root) {
        if (root == null ){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    //求第k层节点个数
    private static int getKLevelSize(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k - 1)
                + getKLevelSize(root.right , k - 1);
    }
    private static TreeNode find(TreeNode root, char tofind) {
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
    //二叉树的最近公共祖先
    private static TreeNode lca = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root , p ,q);
        return lca;
    }
    private static boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
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
    //创建二叉树
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
    //二叉搜索树: 中序遍历有序。
    //二叉树搜索树转换成排序双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (left != null) {
            leftTail .right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }
    //根据一棵树的前序遍历与中序遍历构造二叉树
    //private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,
                                     int inorderLeft,int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder,inorderLeft,inorderRight,root.val);
        root.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        root.right = buildTreeHelper(preorder, inorder,
                pos + 1, inorderRight);
        return root;
    }
    private int  find (int[] inorder,int inorderLeft,
                           int inorderRight,int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    //二叉树创建字符串
    private StringBuilder builder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();

    }
    private void tree2strHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        builder.append("(");
        builder.append(root.val);
        tree2strHelper(root.left);
        if (root.left == null && root.right != null) {
            builder.append("()");
        }
        tree2strHelper(root.right);
        builder.append(")");
    }
    //先序遍历（非递归）
    public void preOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //中序遍历（非递归）
    public static void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }

    }
    //后序遍历（非递归）
    //后序遍历中当前节点和右子树的根节点相邻
    //可以判定一下上一个访问元素书不是 当前栈顶元素的右子树
    //如果是 当前元素的右子树已经访问过了，就可以访问当前元素。
    public static void postOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
               break;
            }
            TreeNode top = stack.peek();
            if (top.right == null && prev == top.right) {
                System.out.println(top.val);
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = build();
        inOrder1(root);
    }
}
