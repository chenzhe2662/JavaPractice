import java.util.Stack;

//用用两个栈实现队列
public class MyQueue3 {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();
        /** Initialize your data structure here. */

    /** Push element x to the back of queue. */
        public void push(int x) {
            while (!B.isEmpty()) {
                int tmp = B.pop();
                A.push(tmp);
            }
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (A.isEmpty() && B.isEmpty()) {
                return 0;
            }
            while ( !A.isEmpty() ) {
                int tmp = A.pop();
                B.push(tmp);
            }
            return B.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (A.isEmpty()&&B.isEmpty()) {
                return 0;
            }
            while (!A.isEmpty()) {
                int tmp = A.pop();
                B.push(tmp);
            }
            return B.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return A.isEmpty()&&B.isEmpty();
        }
    }


