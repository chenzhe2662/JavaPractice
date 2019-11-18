import java.util.LinkedList;
import java.util.Stack;

public class Test {
    class MinStack {
        private Stack<Integer> A = new Stack<>();
        private Stack<Integer> B = new Stack<>();
        /** initialize your data structure here. */
        public void push(int x) {
            A.push(x);
            if (B.isEmpty()) {
                push(x);
                return;
            }
            int min = B.peek();
            if (min > x) {
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
    class MyQueue {
        private Stack<Integer> A = new Stack<>();
        /** Initialize your data structure here. */

        /** Push element x to the back of queue. */
        public void push(int x) {
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (A.isEmpty()) {
                return 0;
            }

            return A.remove(0);
        }

        /** Get the front element. */
        public int peek() {
            if (A.isEmpty() ) {
                return 0;
            }
            return A.get(0);
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return A.isEmpty();
        }
    }
    class MyStack {
        private LinkedList<Integer> A = new LinkedList<>();

        /** Initialize your data structure here. */

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            A.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (A.isEmpty()) {
                return 0;
            }
            return A.remove(A.size() - 1);
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (A.isEmpty()) {
                return 0;
            }
            return A.get(A.size() - 1);
        }
        /** Returns whether the stack is empty. */
        public boolean empty() {
            return A.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}
