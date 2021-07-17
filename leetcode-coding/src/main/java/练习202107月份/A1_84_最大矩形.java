package 练习202107月份;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 单调栈
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A1_84_最大矩形 {
    public static void main(String[] args) {
        int res = new A1_84_最大矩形().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
        list.add(0, 0);
        list.add(0);
        for (int i = 0; i < list.size(); ++i) {
            // 发现右侧比栈顶小，无法维持递增单调栈，大于当前元素的全部出栈，组合出矩形，求最大值
            while (!stack.empty() && list.get(stack.peek()) > list.get(i)) {
                // 左边界(包含)
                int index = stack.pop();
                // 左边界左边的位置
                int left = stack.peek();
                // 右边界(包含)
                int right = i - 1;
                // 实际宽度
                int width = right - left;
                max = Math.max(max, list.get(index) * width);
            }
            // 入栈
            stack.push(i);
        }
        return max;
    }
}
