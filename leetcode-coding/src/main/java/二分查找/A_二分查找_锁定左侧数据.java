package 二分查找;

/**
 * @author: keke
 * @date: 2021/7/24 0:01
 */
public class A_二分查找_锁定左侧数据 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5};
        System.out.println(binarySearch(nums, 4));
    }

    /**
     * 二分查找，包含边界的查找方法 [left,right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 查找到目标后，压缩右区间
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
}
