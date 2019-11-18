import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private  int[] elem = new int[100];
    private int top = 0;
    private List<Integer> list = new ArrayList<>();
    public void push(int val) {
        elem[top] = val;
        top++;
    }
    private void push2(int val) {
        list.add(0,val);
    }
    private void pop2() {
        if (list.isEmpty()) {
            return;
        }
        list.remove(0);
    }
    private Integer peek2() {
        if (list.isEmpty()) {
            return  null;
        }
        return list.get(0);
    }
    public Integer pop() {
        if (top == 0) {
            return null;
        }
        int ret = elem[top - 1];
        top--;
        return  ret;
    }
    public Integer peek() {
        if (top == 0) {
            return null;
        }
        return elem[top - 1];
    }
    public boolean isEmpty() {
        return top == 0;
    }
    public int size() {
        return top;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push2(1);
        myStack.push2(2);
        myStack.push2(3);
        myStack.push2(4);
        myStack.pop2();
        System.out.println(myStack.peek2());
    }
}
