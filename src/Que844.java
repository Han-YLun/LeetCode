import java.io.CharConversionException;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/07/31
 **/
public class Que844 {

    public boolean backspaceCompare(String S, String T) {

        Stack<Character> firstStack = new Stack<Character>();
        Stack<Character> secondStack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {

            char c = S.charAt(i);
            if (c == '#' && !firstStack.isEmpty()){
                firstStack.pop();
            }else{
                firstStack.push(c);
            }
        }

        for (int i = 0; i < T.length(); i++) {

            char c = T.charAt(i);
            if (c == '#' && !secondStack.isEmpty()){
                secondStack.pop();
            }else if (c != '#'){
                secondStack.push(c);
            }
        }

        S = "";
        T = "";

        StringBuilder sb = new StringBuilder();
        while (!firstStack.isEmpty()){

            sb.append(firstStack.pop());
        }

        S = sb.toString();
        sb.replace(0,sb.length(),"");

        while (!secondStack.isEmpty()){

            sb.append(secondStack.pop());
        }

        T = sb.toString();

        return S.equals(T);
    }

    public static void main(String[] args) {
        new Que844().backspaceCompare("y#fo##f","y#f#o##f");
    }
}
