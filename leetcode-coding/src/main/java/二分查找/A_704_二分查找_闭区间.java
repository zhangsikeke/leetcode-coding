package 二分查找;

import java.util.List;

/**
 * @author: keke
 * @date: 2021/7/24 0:01
 */
public class A_704_二分查找_闭区间 {
    /**
     * 二分查找，包含边界的查找方法 [left,right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        // 注意使用闭区间
        int right = nums.length - 1;
        // 注意是"<="
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
