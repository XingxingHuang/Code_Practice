/*
 * 牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:
 * 最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。 
 * 
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 10^5),即数列的长度;
 * 第二行n个整数a_i, 表示数列中的每个数(1 ≤ a_i ≤ 10^9),以空格分割。
 * 
 * 输出描述:
 * 输出一个整数,表示最长的长度。
 * 
 * 输入例子:
 * 6 
 * 7 2 3 1 5 6
 * 
 * 输出例子:
 * 5
 * 
 * 思路: 
 * 题目要求的是最长的递增子数组，但是可以修改某一字符。因此可以求出某一字符前面最长的递增和其后面最长的递增序列。
 * 通过两次循环遍历可以很容易求得两个数组，记录递增序列的长度。 
 */
import java.util.Scanner;
public class Main {
    private static int check (int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        dec[n - 1] = 1;
        // 计算递增，递减数目
        for (int i = 1; i < n; i++) {
            inc[i] = nums[i] > nums[i - 1] ? inc[i - 1] + 1 : 1;          
        }
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = nums[i] < nums[i + 1] ? dec[i + 1] + 1 : 1;          

        }
        // combine
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, inc[i - 1] + 1);
            res = Math.max(res, dec[i + 1] + 1);
            // 只有大于2中间才能插入一个新数字，保证严格上升
            if (nums[i + 1] - nums[i - 1] >= 2) {
                res = Math.max(res, inc[i - 1] + dec[i + 1] + 1);
            }
        }
        return res;
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