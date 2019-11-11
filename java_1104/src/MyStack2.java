import java.util.LinkedList;
//用两个队列实现栈
public class MyStack2 {
    //A用来入栈，B空辅助取首元素
   private LinkedList<Integer> A = new LinkedList<>();
   private LinkedList<Integer> B = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack2(LinkedList<Integer> a, LinkedList<Integer> b) {
        A = a;
        B = b;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        int ret = A.removeFirst();
        LinkedList<Integer> tmp = A;
        A = B;
        B = tmp;
        return ret;
    }
    private void  Swap() {
        LinkedList<Integer> tmp = A;
        A = B;
        B = tmp;
    }
    /** Get the top element. */
    public int top() {
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        int ret = A.removeFirst();
        B.addLast(ret);
        Swap();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}
