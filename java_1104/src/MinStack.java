import java.util.Stack;

public class MinStack {
    //A正常存储数据
    //B存储每一层的对应的最小值
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();
    public void push(int x) {
        A.push(x);
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
