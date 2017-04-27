package chap03;

/**
 * Created by xing on 4/27/17.
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。

 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。

 测试样例：
 "cdab",4,"abcd",4
 返回：true
 */
import java.util.*;

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if (lena != lenb) {
            return false;
        }
        String str = A + A;
        for (int i = 0; i < str.length(); i++) {
            int start = i;
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt(j) != str.charAt(start + j)) {
                    break;
                }
                if (j == B.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
