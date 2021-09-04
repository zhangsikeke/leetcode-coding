package 周赛.第60周;

/**
 * 前缀和
 *
 * @author: keke
 * @date: 2021/9/5 0:15
 */
public class A1_找到数组的中间位置 {
    public int findMiddleIndex(int[] nums) {
        int[] sum = new int[nums.length];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            sum[i] = tmp;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sumLeft;
            if (i == 0) {
                sumLeft = 0;
            } else {
                sumLeft = sum[i - 1];
            }
            int sumRight = sum[len - 1] - sum[i];
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }
}
