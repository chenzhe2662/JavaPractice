import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
public class TreePractice {
    //层序遍历
    private static List<Integer> levelOrder(Node root) {
        List<Integer> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return new LinkedList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return list;
    }
    //层序遍历二
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return new LinkedList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int count = queue.size();
            while (count > 0) {
                Node cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            result.add(list);
        }
        return result;
    }
    //是否是完全二叉树
    private boolean isCompleteTree(Node root) {

        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
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
    //先序遍历：
    public void preOrder (Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }
}
