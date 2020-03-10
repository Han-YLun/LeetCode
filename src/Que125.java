/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que125 {

    public boolean isPalindrome(String s) {

        int start =0,end = s.length()-1;
        while (start < end ){

            if (!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
                start++;
            }else if (!Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
                end --;
            }else if(Character.toUpperCase(s.charAt(start))  != Character.toUpperCase(s.charAt(end))
                ){

                return false;
            }else{
                start++;
                end--;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Que125 que125 = new Que125();
        System.out.println(que125.isPalindrome("race a car"));
    }
}
