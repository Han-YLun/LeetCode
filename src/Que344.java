/**
 * @author: hyl
 * @date: 2021/03/26
 **/
public class Que344 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public void reverseString1(char[] s) {
        int indexI = 0, indexJ = s.length - 1;
        char temp;
        while (indexI < indexJ) {
            if (s[indexI] != s[indexJ]) {
                temp = s[indexI];
                s[indexI] = s[indexJ];
                s[indexJ] = temp;
            }
            indexI++;
            indexJ--;
        }
    }

}
