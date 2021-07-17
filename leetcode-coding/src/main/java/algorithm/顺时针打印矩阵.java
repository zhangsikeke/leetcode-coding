package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[] {};
        }
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 从左向右打
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }
            // 从右到左
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
