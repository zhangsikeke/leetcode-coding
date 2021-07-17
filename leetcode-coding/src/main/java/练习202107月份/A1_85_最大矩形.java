package 练习202107月份;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 暴力求解或利用84题求解
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A1_85_最大矩形 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        int[] heights = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            // 以每行作为底部，按照leetcode 84求解
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
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


    // 暴力（超时）
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int ii = i; ii < r; ii++) {
                for (int j = 0; j < c; j++) {
                    for (int jj = j; jj < c; jj++) {
                        int sum = getSum(matrix, i, ii, j, jj);
                        int total = ((ii - i) + 1) * ((jj - j) + 1);
                        max = Math.max(max, sum == total ? sum : -1);
                    }
                }
            }
        }
        return max;
    }

    private int getSum(char[][] matrix, int r1, int r2, int c1, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (matrix[i][j] == '0') {
                    return 0;
                }
                sum += Integer.parseInt(String.valueOf(matrix[i][j]));
            }
        }
        return sum;
    }
}
