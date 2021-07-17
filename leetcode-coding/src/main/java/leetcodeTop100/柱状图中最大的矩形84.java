package leetcodeTop100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: keke
 * @date: 2021/6/27 22:38
 */
public class 柱状图中最大的矩形84 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea1(nums));
        System.out.println(largestRectangleArea2(nums));

    }


    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int w = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                w++;
                left--;
            }
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
                w++;
            }
            max = Math.max(max, w * heights[i]);
        }
        return max;
    }

    public static int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
        list.add(0, 0);
        list.add(0);
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.empty() && list.get(stack.peek()) > list.get(i)) {
                int index = stack.peek();
                stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, list.get(index) * (i - left - 1));
            }
            stack.push(i);
        }
        return max;
    }

    //    总结来说，我们分析一下这个问题，要求矩形的最小面积，利用暴力法我们可以先设定一个元素的高度，然后向两边找不小于它的边界，就可以得到答案
//            但是这样的话时间复杂度就太高了
//    我们就想到，既然你要求出最大面积，那我们可以构建一个单调递增的栈，当遇到使矩形被破坏，也就是不能达成递增的情况下。
//    想象左边的那些元素依次向该新位置切割，找到最大的
//    我们计算该元素之前的那些元素的矩形面积，并把这些已经计算完成的元素剔除，不断进行就能达成目的
    public static int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
        list.add(0, 0);
        list.add(0);
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek()) > list.get(i)) {
                //这里是说，我们需要维护一个单调递增的栈，如果碰到小于栈顶元素的我们就弹出原来的栈顶元素，并计算其围成的矩形的面积
                System.out.println("ok--cur," + list.get(i) + "," + stack);
                int index = stack.peek();
                stack.pop();
                //左侧是st.top(),也就是该元素之前的元素位置
                int left = stack.empty() ?0 : stack.peek();
                System.out.println("index:" + index + ",left:" + left + ",max:" + list.get(index) + "," + (list.get(index) * (i - left - 1)));
                max = Math.max(max, list.get(index) * (i - left - 1));
            }
            //push的是索引，比较的是数组，这样可以定位到数组元素在栈里的位置
            stack.push(i);
            System.out.println("s----" + stack);
        }
        return max;
    }
}
