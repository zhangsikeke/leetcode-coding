package 练习202107月份;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+hash
 * 7道题：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A17_525_连续的数组 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        map.put(0, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;

    }
}
