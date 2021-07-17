package 练习202107月份;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟
 *
 * @author: keke
 * @date: 2021/7/4 22:13
 */
public class A8_54_螺旋矩阵 {
    public static void main(String[] args) {
        new A8_54_螺旋矩阵().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 向右打印
            for (int i = left; i <= right; i++) {
                System.out.println("右" + matrix[top][i]);
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            // 向下打印
            for (int i = top; i <= bottom; i++) {
                System.out.println("下" + matrix[i][right]);
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            // 向左打印
            for (int i = right; i >= left; i--) {
                System.out.println("左" + matrix[bottom][i]);
                list.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            // 向上打印
            for (int i = bottom; i >= top; i--) {
                System.out.println("上" + matrix[i][left]);
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        System.out.println(list);
        return list;
    }
}