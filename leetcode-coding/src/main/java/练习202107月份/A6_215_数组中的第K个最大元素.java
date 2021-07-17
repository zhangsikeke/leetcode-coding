package 练习202107月份;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 大顶堆
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A6_215_数组中的第K个最大元素 {
    // 排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 大顶堆
    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        int res = Integer.MIN_VALUE;
        while (k > 0) {
            res = queue.poll();
            k--;
        }
        return res;
    }
}
