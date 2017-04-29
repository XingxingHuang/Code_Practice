package chap03_string;

/**
 * Created by xing on 4/26/17.
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class IdenticalTree {
    public boolean chkIdentical(TreeNode t1, TreeNode t2){
        String t1Str = serialByPre(t1);
        String t2Str = serialByPre(t2);
        return getIndexOf(t1Str, t2Str) != -1;
    }

    //KMP
    private int getIndexOf(String s, String m) {
        if(s == null || m == null || m.length() < 1 ||s.length() < m.length()){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();

        int[] nextArr = getNextArray(ms);
        int index = 0;
        int mi = 0;
        while(index < ss.length && mi < ms.length){
            if(ss[index] == ms[mi]){
                index++;
                mi++;
            }else if(nextArr[mi] == -1){
                index++;
            }else{
                mi = nextArr[mi];
            }
        }
        return mi == ms.length? index - mi: -1;
    }

    private static int[] getNextArray(char[] ms) {
        if(ms.length == 1){
            return new int[]{-1};
        }
        int[] nextArr = new int[ms.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < nextArr.length){
            if(ms[pos - 1] == ms[cn]){
                nextArr[pos++] = ++cn;
            }else if(cn > 0){
                cn = nextArr[cn];
            }else{
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }

    private String serialByPre(TreeNode head) {
        if(head == null){
            return "#!";
        }

        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
}

