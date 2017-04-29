package chap03_string;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。

 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。

 测试样例：
 "abc",3,"bca",3
 返回：true
 */

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < a.length; i++) {
            map[a[i] - ' ']++;
        }
        for (int i = 0; i < b.length; i++) {
            map[b[i] - ' ']--;
            if (map[b[i] - ' '] < 0) {
                return false;
            }
        }
        return true;
    }
}
