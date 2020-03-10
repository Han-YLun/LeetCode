/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que917 {

    public String reverseOnlyLetters(String S) {

        StringBuilder sb = new StringBuilder(S);

        int len = S.length();
        int start = 0,
                end = len-1;
        while (start <= end){

            if (!Character.isLetter(sb.charAt(start))){
                start++;
            }else if (!Character.isLetter(sb.charAt(end))){
                end--;
            }else{
                char c = sb.charAt(start);
                sb.replace(start, start +1,sb.charAt(end)+"");
                sb.replace(end, end+1,c+"");
                start++;
                end --;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Que917 que917 = new Que917();
        que917.reverseOnlyLetters("ab-cd");
    }
}
