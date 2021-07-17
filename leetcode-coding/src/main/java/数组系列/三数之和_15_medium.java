package 数组系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 三数之和_15_medium {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right) {
                    if (target > nums[left] + nums[right]) {
                        left++;
                    } else if (target < nums[left] + nums[right]) {
                        right--;
                    } else {
                        List<Integer> list = Arrays.stream(new int[] {nums[i], nums[left], nums[right]}).boxed()
                            .collect(Collectors.toList());
                        res.add(list);
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    }
                }
            }

        }
        return res;
    }
}
