import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que225 {

    class MyStack {

        private Queue<Integer> inQueue;
        private Queue<Integer> outQueue;

        /** Initialize your data structure here. */
        public MyStack() {
            inQueue = new ArrayDeque<Integer>();
            outQueue = new ArrayDeque<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            inQueue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {

            while (inQueue.size() != 1){
                outQueue.add(inQueue.poll());
            }

            int tmp = inQueue.poll();

            while (outQueue.size() != 0){
                inQueue.add(outQueue.poll());
            }

            return tmp;
        }

        /** Get the top element. */
        public int top() {
            while (inQueue.size() != 1){
                outQueue.add(inQueue.poll());
            }

            return inQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return inQueue.isEmpty() && outQueue.isEmpty();
        }


    }
}
