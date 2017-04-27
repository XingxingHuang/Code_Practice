package chap03;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。

 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。

 测试样例：
 "abc",3,"bca",3
 返回：true
 */
import java.util.*;

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(b[i])) {
                return false;
            }
            if (map.get(b[i]) == 0) {
                return false;
            }
            map.put(b[i], map.get(b[i]) - 1);
        }
        return true;
    }
}
