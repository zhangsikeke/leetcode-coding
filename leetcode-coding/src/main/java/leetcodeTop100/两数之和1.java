package leetcodeTop100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: keke
 * @date: 2021/6/25 21:25
 */
public class 两数之和1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{i, map.get(tmp)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
