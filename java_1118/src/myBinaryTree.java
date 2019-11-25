
import java.util.*;

public class myBinaryTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    private static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    //先序遍历
    private static void prevOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //中序遍历
    private static void inOder(Node root) {
        if (root == null) {
            return;
        }
        inOder(root.left);
        System.out.print(root.val + " ");
        inOder(root.right);
    }
    //后序遍历
    private static void postOder(Node root) {
        if (root == null) {
            return;
        }
        postOder(root.left);
        postOder(root.right);
        System.out.print(root.val + " ");
    }
    // 遍历思路-求结点个数
    private static int size = 0;
    private static void getSize1(Node root) {
        if (root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    private static int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize2(root.left) + getSize2(root.right);
    }
    // 遍历思路-求叶子结点个数
    private static int leafSize = 0;
    private static void getLeafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    private static int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return  1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    // 子问题思路-求第 k 层结点个数
    private static int getKLevelSize(Node root, int k) {
        if (root == null || k < 1 ) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k - 1) +
                 getKLevelSize(root.right,k - 1);
    }
    //查找 val 所在结点，没有找到返回 null
    private static Node find(Node root, char val) {
       if (root == null) {
           return null;
       }
       if (root.val == val) {
           return root;
       }
       Node ret = find(root.left,val);
       if (ret != null) {
           return ret;
       }
       return find(root.right,val);
    }
    public static void main1(String[] args) {
        Node node = build();
        prevOrder(node);
        System.out.println();
        inOder(node);
        System.out.println();
        postOder(node);
        System.out.println();
        getSize1(node);
        System.out.println(size);
        System.out.println(getSize2(node));
        getLeafSize1(node);
        System.out.println(leafSize);
        System.out.println(getLeafSize2(node));
        System.out.println(getKLevelSize(node,3));
        System.out.println(find(node,'E'));
    }
    // 中序遍历
    // 先序遍历
    // 后序遍历
    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> inorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    // 检查两颗树是否相同
    private static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) &&
                    isSameTree(p.right,q.right);
    }
    // 另一颗树的子树。
    private static boolean isSubtree(Node s, Node t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        if (!ret) {
            ret = isSubtree(s.left,t);
        }
        if (!ret) {
            ret = isSubtree(s.right,t);
        }
        return ret;
    }
    // 二叉树最大深度
    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ?
                leftDepth : rightDepth);
    }
    // 判断一颗二叉树是否是平衡二叉树。
    // 左右子树深度差小于等于1为平衡树
    private static boolean isBalanced(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int depth = leftDepth > rightDepth ?
                leftDepth - rightDepth : rightDepth - leftDepth;
        if (depth <= 1) {
           return true;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    // 对称二叉树
    private static boolean isSymmetric(Node root) {
        if (root == null) {
            return false;
        }
        Node p = root.left;
        Node q = root.right;
        return isMirror(p,q);
    }
    private static boolean isMirror(Node p, Node q) {
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left,q.right) && isMirror(p.left,q.right);
    }
    // 制作一颗镜像树
    private static Node MakeMirror (Node root) {
        if (root == null) {
            return null;
        }
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
    public static void main(String[] args) {
        Node node = build();
        inOder(node);
        System.out.println();
        System.out.println(inorderTraversal(node));
        System.out.println(isSameTree(node,node.left));
        System.out.println(isSubtree(node.left,node));
        System.out.println(maxDepth(node));
        System.out.println(isBalanced(node));
        System.out.println(isSymmetric(node));
    }
    // 二叉树的构建及遍历
    private static  int i =0;
    public  static Node buildTree2(String str) {
        if (str == null) {
            return null;
        }
        Node root = new Node(str.charAt(i));
        if (str.charAt(i) != '#') {
            i++;
            root.left = buildTree2(str);
            i++;
            root.right = buildTree2(str);
        }else {
            return null;
        }
        return root;
    }
    private static  int index = 0;
    private static Node buildTree(String line) {
        index = 0;
        return createTreePreOrder(line);
    }
    private static Node createTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        Node root = new Node(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
    // 二叉树的分层遍历
    private static List<Integer> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        //List<Integer> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return list;
    }
    //二叉树的公共祖先
    private static Node lowestCommonAncestor1(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right ,p,q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    //p和q都在左树，p和q都在右树，p和q在不在一边
    private static Node lca = null;
    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private static boolean findNode(Node root, Node p, Node q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            lca = root;
        }
        return left + right + mid > 0;
    }
    //二叉树搜索树转换成排序双向链表。
    //如果左树不为空左树所有值小于根节点
    //如果右树不为空右树所有值大于根节点
    //如果树为空也是
    //子树也符合以上
    //即为二叉搜索树
    public  Node prev = null;
    public   void inOder1(Node root) {
        if (root == null) {
            return;
        }

        inOder(root.left);
        root.left = prev;
        if (prev != null ) {
            prev.right = root;
        }
        prev = root;
        inOder(root.right);

    }
    public Node Convert1(Node pRootOfTree) {
        inOder(pRootOfTree);
        Node head = pRootOfTree;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
    private static Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null &&
                    pRootOfTree.right == null) {
            return pRootOfTree;
        }
        Node left = Convert(pRootOfTree.left);
        Node prev = left;
        while (prev != null && prev.right != null) {
            prev = prev.right;
        }
        if (left != null) {
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
        }
        Node right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }
    //根据一棵树的前序遍历与中序遍历构造二叉树

    public Node buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,
                inorder,0,inorder.length);
    }
    private Node buildTreeHelper(int[] preorder,int[] inorder,
                                     int inorderLeft,int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        Node root = new Node(preorder[index]);
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
    // 二叉树创建字符串
    private static StringBuilder builder = new StringBuilder();
    public static String tree2str(Node t) {
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        return builder.toString();
    }
    private static void tree2strHelper(Node root) {
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
    public static void main3(String[] args) {
        String str = "abc##de#g##f###";
        Node node = buildTree(str);
        inOder(node);
        System.out.println();
        System.out.println(levelOrder(node));
        System.out.println(lowestCommonAncestor(node,
                node.left.left,node.left.right.left));
        Node cur = build();
        Convert(cur);
    }
    //先序遍历（非递归）
    public void preOrder (Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
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
    public static void inOrder1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                cur = stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    //后序遍历（非递归）
    //后序遍历中当前节点和右子树的根节点相邻
    //可以判定一下上一个访问元素书不是 当前栈顶元素的右子树
    //如果是 当前元素的右子树已经访问过了，就可以访问当前元素。
    public static void postOrder (Node root) {
        if (root == null ) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flag = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (root.right == null &&
                    flag == root.right) {
                System.out.print(cur.val);
                cur = stack.pop();
                flag = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
    }
    //是否是完全二叉树
    private boolean isCompleteTree(Node root) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
               if (cur != null) {
                   queue.offer(root.left);
                   queue.offer(root.right);
               } else {
                   break;
               }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }


}
