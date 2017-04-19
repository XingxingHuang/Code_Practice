public class KMPMatch {

    // 计算部分匹配表
    public static int[] getNext(String pattern) {
        int j = 0, k = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (-1 == k || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    // KMP算法
    static int kmpMatch(String target, String pattern) {
        int i = 0, j = 0, index = 0;
        int[] next = getNext(pattern); // 计算部分匹配表

        while (i < target.length() && j < pattern.length()) {
            if (-1 == j || target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j]; // 如果出现部分不匹配，获取跳过的位置
            }
        }

        if (j >= pattern.length())
            index = i - pattern.length(); // 匹配成功，返回匹配子串的首字符下标
        else
            index = -1; // 匹配失败

        return index;

    }

    // 打印完整序列
    public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String target = "ababcabcacbab";
        String pattern = "abcac";
        int index = kmpMatch(target, pattern);
        System.out.format("[%s] is in the pos = %d of [%s]", pattern, index, target);
    }

}



KMP算法之JAVA实现