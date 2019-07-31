import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/07/31
 **/
public class Que20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{

                if (stack.isEmpty()){
                    return false;
                }
                if (c == ')'){
                    if (stack.peek() != '('){
                        return false;
                    }
                }

                if (c == ']'){
                    if (stack.peek() != '['){
                        return false;
                    }
                }

                if (c == '}'){
                    if (stack.peek() != '{'){
                        return false;
                    }
                }

                stack.pop();
            }
        }


        return stack.isEmpty();

    }

    public boolean isValid1(String s) {


        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>(){};

        map.put(')','(');
        map.put('}','{');
        map.put(']','[');


        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if (map.get(c) == null){
                stack.push(c);
            }else{
                if (stack.isEmpty() || map.get(c) != stack.pop()){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    public boolean isValid2(String s) {

        int len;

        do {
            len = s.length();
            s = s.replace("()","").replace("{}","").replace("[]","");

        }while(len != s.length());



        return s.length() == 0;

    }
}
