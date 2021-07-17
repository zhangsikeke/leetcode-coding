package 练习202107月份;

/**
 * 模拟
 *
 * @author: keke
 * @date: 2021/7/4 22:13
 */
public class A8_48_旋转图像 {
    public static void main(String[] args) {
        new A8_48_旋转图像().rotate(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});
    }

    public void rotate(int[][] matrix) {
        // 控制层
        for (int x = 0, y = matrix[0].length - 1; x < y; x++, y--) {
            // 控制圈
            for (int s = x, e = y; s < y; s++, e--) {
                int tmp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}