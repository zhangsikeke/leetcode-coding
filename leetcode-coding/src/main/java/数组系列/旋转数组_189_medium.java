package 数组系列;

/**
 * 189.https://leetcode-cn.com/problems/rotate-array/
 * 
 * @author keke
 * @date 2020/11/21
 */
public class 旋转数组_189_medium {
    /**
     * 这个方法基于这个事实：若我们需要将数组中的元素向右移动 k 个位置， 那么 k%n (n为数组长度) 的尾部元素会被移动到头部，剩下的元素会被向后移动
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp = 0;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
