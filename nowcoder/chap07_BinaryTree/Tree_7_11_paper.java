package chap07_BinaryTree;

/**
 * Created by xing on 5/1/17.
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。

 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".

 测试样例：
 1
 返回：["down"]
 */
import java.util.*;

public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        ArrayList<String> list = new ArrayList<String>();
        int times = 1;
        boolean down = true;
        fold(times, n, down, list);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void fold(int times, int n, boolean down, ArrayList<String> list) {
        if (times > n) {
            return;
        }
        // 依次加入折痕的左边有和右边
        fold(times + 1, n, true, list);
        list.add(down == true ? "down" : "up");
        fold(times + 1, n, false, list);
    }
}
