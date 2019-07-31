import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que232 {
    class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {

            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {

            if (outStack.isEmpty()){
                trans();
            }


            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.isEmpty()){
                trans();
            }
            return outStack.peek();
        }

        private void trans() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {

            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
