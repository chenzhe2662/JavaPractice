import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '['|| ch == '{' ) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char top = stack.pop();
            if (ch == ')' && top == '('||
                    ch == ']' && top == '['||
                    ch == '}' && top == '{') {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
