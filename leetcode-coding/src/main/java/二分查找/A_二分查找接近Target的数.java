package 二分查找;

import java.util.Arrays;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/7/24 0:01
 */
public class A_二分查找接近Target的数 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6, 8, 11, 18, 25, 50};
        Arrays.sort(nums);
        System.out.println(binarySearch(nums, 21));
    }

    /**
     * 找到最接近target的数的index
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (target >= nums[nums.length - 1]) {
            return nums.length - 1;
        }
        if (target <= nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return Math.abs(target - nums[left]) < Math.abs(target - nums[right]) ? left : right;
    }
}
