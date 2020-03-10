/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que520 {

    public boolean detectCapitalUse(String word) {

        int len = word.length();
        int upperCase = 0,
                lowerCase = 0;
        if (len < 2){
            return true;
        }

        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                upperCase++;
            }else{
                lowerCase++;
            }
        }

        //System.out.println(upperCase + ":" + lowerCase);
        if (lowerCase == len || upperCase == len){
            return true;
        }else if(upperCase == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Que520 q = new Que520();
        q.detectCapitalUse(new String("ffffffffffffffffffffF"));
    }
}
