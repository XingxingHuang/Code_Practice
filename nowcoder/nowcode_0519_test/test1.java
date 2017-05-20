import java.util.Scanner;
public class Main {
    private static boolean check (int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        // corner case
        int n = nums[0];
        // bit right move
        if (n != 0) {
            while ((n & 1) != 1) {
                n = n >>> 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (n == 0 && nums[i] != n) {
                return false;
            } 
            if (n != 0 && nums[i] == 0) {
                return false;
            }
            if (n == 0 && nums[i] == 0) {
                continue;
            } else {
                int temp = nums[i];
                while ((temp & 1) != 1) {
                    temp = temp >>> 1;
                }
                if (n != temp) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        } 
        if (check(nums)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}