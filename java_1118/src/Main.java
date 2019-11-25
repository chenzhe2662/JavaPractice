import java.util.Scanner;
import java.util.Stack;

class Node {
    char val;
    Node left;
    Node right;

    Node(char val) {
        this.val = val;
    }
}
public class Main {
    public static void preOrder (Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    private static  int i =0;
    public  static Node buildTree(String str) {
        if (str == null) {
            return null;
        }
        Node root = new Node(str.charAt(i));
        if (str.charAt(i) != '#') {
            i++;
            root.left = buildTree(str);
            i++;
            root.right = buildTree(str);
        }else {
            return null;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Node node = buildTree(str);
        preOrder(node);

    }
}