package 练习202107月份;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 优先队列
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A7_239_滑动窗口最大值 {
    public static void main(String[] args) {
        new A7_239_滑动窗口最大值().maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6,}, 5);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            // 滑动超出范围，移除队头
            while (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                queue.removeFirst();
            }
            // 如果新来的数比对尾大，则删除队尾
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 将最大的数放在队尾
            queue.offerLast(i);

            // 窗口最后一位数时，对头则是最大的数
            if (i - k + 1 >= 0) {
                res.add(nums[queue.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
