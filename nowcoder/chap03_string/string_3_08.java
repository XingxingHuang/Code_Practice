package chap03_string;

/**
 * Created by xing on 4/27/17.
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。

 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。

 测试样例：
 ["abc","de"],2
 "abcde"
 */
import java.util.*;

public class Prior {
    public String findSmallest(String[] strs, int n) {
        // write code here
        if (strs == null || strs.length == 0) {
            return null;
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        // ???
        // Arrays.sort(strs, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}

import java.util.*;

public class Prior {
    public class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public String findSmallest(String[] strs, int n) {
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str:strs) {
            res.append(str);
        }
        return res.toString();
    }
}
