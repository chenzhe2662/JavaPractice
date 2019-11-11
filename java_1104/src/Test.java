import java.util.Scanner;
import java.util.Stack;

public class Test {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char top = stack.pop();
            if (top == '(' && ch == ')') {
                continue;
            }
            if (top == '[' && ch == ']') {
                continue;
            }
            if (top == '{' && ch == '}') {
                continue;
            }
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int size = 5;
        System.out.println(a[size--]);
        System.out.println(a[--size]);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            StringBuffer str2 = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (str2.toString().contains(str.charAt(i) + "")) {
                    continue;
                }
                str2.append(str.charAt(i));
            }
            System.out.println(str2);
        }

    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (!buffer.toString().contains(temp + "")) {
                    buffer.append(temp);
                }
            }
            System.out.println(buffer.toString());
        }
    }
}
