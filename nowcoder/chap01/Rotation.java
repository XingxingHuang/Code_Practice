package chap01;

/**
 * Created by xing on 4/25/17.
 */
import java.util.*;

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if (lena != lenb) {
            return false;
        }
        String str = A + A;
        return str.contains(B);
        for (int i = 0; i < str.length(); i++) {
            int start = i;
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt())
            }
        }
    }
}
