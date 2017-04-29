package chap03_string;

/**
 * Created by xing on 4/27/17.
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。

 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。

 测试样例：
 "ABCDE",5,3
 返回："DEABC"
 */

public class Translation {
    public String stringTranslation(String A, int n, int len) {
        // write code here
        char[] a = A.toCharArray();
        reverseChars(a, 0, len);
        reverseChars(a, len, n);
        reverseChars(a, 0, a.length);
        return String.valueOf(a);
    }
    public void reverseChars(char[] chars, int i , int j) {
        while (i < j - 1) {
            char temp = chars[i];
            chars[i] = chars[j - 1];
            chars[j - 1] = temp;
            i++;
            j--;
        }
    }
}
