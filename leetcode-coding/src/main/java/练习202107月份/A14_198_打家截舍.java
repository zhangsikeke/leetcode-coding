package 练习202107月份;

/**
 * 动态规划
 *
 * @author: keke
 * @date: 2021/7/10 22:24
 */
public class A14_198_打家截舍 {

    public static void main(String[] args) {
        int res = new A14_198_打家截舍().rob(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
