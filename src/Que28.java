/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */
public class Que28 {

    public int strStr(String haystack, String needle) {

        if (needle.equals("")){
            return 0;
        }

        int index = 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)){
                i = i+1;
                int j =index+1;
               while(j < needle.length()){
                    if (i >= haystack.length()){
                        return -1;
                    }

                    if (haystack.charAt(i) == needle.charAt(j)){
                        i++;
                        j++;
                    }else{
                        break;
                    }
                }

               if (j >= needle.length()){
                   return i-needle.length();
               }

               i -= j;
            }
        }

        return -1;
    }

    public int strStr1(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }

        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();

        int i=0, j = 0;

        while (i < hayArr.length && j < needArr.length){

            if (hayArr[i] == needArr[j]){
                i++;
                j++;
            }else{
                i = i -j +1;
                j =0;
            }
        }

        if (j >= needArr.length){
            return i - j;
        }else{
            return -1;
        }

    }
    

    public static void main(String[] args) {
        Que28 que28 = new Que28();
        int i = que28.strStr("mississippi",
                "issip");
        System.out.println(i);
    }
}
