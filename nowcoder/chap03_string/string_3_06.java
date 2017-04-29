package chap03_string;

/**
 * Created by xing on 4/27/17.
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。

 给定一个原字符串A和他的长度，请返回逆序后的字符串。

 测试样例：
 "dog loves pig",13
 返回："pig loves dog"

 */

public class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();
        int start = -1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseCharArray(chars, start + 1, i);
                start = i;
            }
        }
        //if (start < chars.length - 1) {
        //    reverseCharArray(chars, start + 1, chars.length);
        //}
        reverseCharArray(chars, start + 1, chars.length);
        reverseCharArray(chars, 0, chars.length);
        return String.valueOf(chars);
    }
    public void reverseCharArray(char[] chars, int i, int j) {
        while (i < j - 1) {
            char temp = chars[i];
            chars[i] = chars[j - 1];
            chars[j - 1] = temp;
            i++;
            j--;
        }
    }
}
