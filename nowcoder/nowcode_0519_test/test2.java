/*
 * 牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
 * 如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2 
 * 
 * 输入描述:
 * 输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)
 * 第二行包括n个整数A_i(1 ≤ A_i ≤ 10^9),表示数组A的每个数字。
 * 
 * 输出描述:
 * 输出一个整数表示牛牛可以将A最少划分为多少段排序子序列
 * 
 * 输入例子:
 * 6
 * 1 2 3 2 2 1
 * 
 * 输出例子:
 * 2
 * 
 * 注: 
 * 【1】动态规划思想。只有当新的数据与前面规律不相符的时候，分组数目才会增加。
 * 【2】用栈记录数据的信息，考虑新增数据的大小与栈中元素关系。
 */
// 方法一
import java.util.Scanner;
public class Main {
    private static int check (int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 1;
        }
        int n = nums.length;
        int sign = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {              
            // check the dp
            //if (nums[i] == nums[i - 1] || sign == 0) {
            //    dp[i] = dp[i - 1];
            //} else 
            if ( (nums[i] > nums[i - 1] && sign == -1) || (nums[i] < nums[i - 1] && sign == 1)) {
                dp[i] = dp[i - 1] + 1;
                //sign = -sign;
                sign = 0;
            } else {
                dp[i] = dp[i - 1];
                // renew the sign 
                if (sign == 0 && nums[i] != nums[i - 1]) {
                    if (nums[i] > nums[i - 1]) {
                        sign = 1;
                    } else if (nums[i] < nums[i - 1]) {
                        sign = -1;
                    }
                } 
            }   
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        } 
        System.out.println(check(nums));
    }
}

// 方法二
import java.util.Scanner;
import java.util.Deque;  
import java.util.LinkedList;  
public class Main {
    private static int check (int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 1;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int top = deque.peekFirst();
            int bottom = deque.peekLast();
            if ((bottom > top && bottom > nums[i]) || (bottom < top && bottom < nums[i])) {
                count++;
                deque.clear();
            } 
            deque.offer(nums[i]);
            // System.out.println(deque.toString() + " " + i);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        } 
        // int[] nums = new int[] {1, 2, 3, 2, 2, 1};
        // int[] nums = new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1};
        System.out.println(check(nums));
    }
}