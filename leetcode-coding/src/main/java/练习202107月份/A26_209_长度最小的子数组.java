package 练习202107月份;

/**
 * @author: keke
 * @date: 2021/7/24 22:57
 */
public class A26_209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        A26_209_长度最小的子数组 test = new A26_209_长度最小的子数组();
        System.out.println(test.minSubArrayLen(11, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, (j - i + 1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
