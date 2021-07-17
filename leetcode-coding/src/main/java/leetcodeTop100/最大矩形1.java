package leetcodeTop100;

/**
 * @author: keke
 * @date: 2021/6/27 22:38
 */
public class 最大矩形1 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        maximalRectangle(matrix);

    }

    private static int[][] dp = null;

    public static int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int ii = i; ii < r; ii++) {
                System.out.println("---行:" + i + "," + ii);
                for (int j = 0; j < c; j++) {
                    for (int jj = j; jj < c; jj++) {
                        System.out.print(j + "," + jj + " ");
                        int sum = getSum(matrix, i, ii, j, jj);
                        int total = ((ii - i) + 1) * ((jj - j) + 1);
                        max = Math.max(max, sum == total ? sum : -1);

                    }
                }
                System.out.println("\n--------");
            }
        }
        System.out.println(max);
        return max;
    }

    private static int getSum(char[][] matrix, int r1, int r2, int c1, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (matrix[i][j] == '0') {
                    return -1;
                }
                sum += Integer.parseInt(String.valueOf(matrix[i][j]));
            }
        }
        return sum;
    }
}
