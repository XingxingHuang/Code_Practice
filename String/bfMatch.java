public class BFMatch {

    static int bfMatch(String target, String pattern) {
        int pos = -1;
        int i = 0, j = 0, k = 0;

        // 在没找到匹配pattern的子串前，遍历整个target
        while (-1 == pos && i < target.length()) {

            // 将目标串和模式串逐一比对，如果有不同的则退出
            while (j < pattern.length() && target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j >= pattern.length()) { // 如果模式串扫描完，说明目标串中含有这个子串
                pos = k;
            } else { // 反之，没有扫描完，则从目标串的下一个字符开始重新逐一比对
                j = 0;
                k++;
                i = k;
            }
        }

        return pos;
    }

    public static void print(String target, String pattern, int index) {
        if (-1 != index) {
            System.out.format("[%s] is in the Pos = %d of [%s]\n", pattern, index, target);
        } else {
            System.out.format("[%s] is not in the [%s]\n", pattern, target);
        }
    }

    public static void main(String[] args) {
        String target = "Hello World";
        String pattern = "llo";
        String pattern2 = "Woe";

        int index = bfMatch(target, pattern);
        int index2 = bfMatch(target, pattern2);
        print(target, pattern, index);
        print(target, pattern2, index2);

    }

}



BF算法之JAVA实现