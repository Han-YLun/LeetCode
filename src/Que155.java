import java.util.Stack;

/**
 * @author: hyl
 * @date: 2021/03/31
 **/
public class Que155 {

    class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
