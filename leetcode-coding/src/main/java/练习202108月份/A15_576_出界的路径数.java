package 练习202108月份;

/**
 * @author: keke
 * @date: 2021/8/5 23:32
 */
public class A15_576_出界的路径数 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        A15_576_出界的路径数 test = new A15_576_出界的路径数();
        System.out.println(test.findPaths(8, 50, 23, 5, 26));
    }

    // dp[i][j][k] 从i,j位置走k步走出圈外的走法，则dp[i][j][k]等于k-1步时上下左右走到i,j位置之和
    // dp[i][j][k] = dp[i+1][j][k-1] + dp[i-1][j][k-1]+ dp[i][j-1][k-1]+ dp[i][j+1][k-1]
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        if (maxMove == 0) return 0;
        long[][][] dp = new long[m + 2][n + 2][maxMove + 1];
        for (int i = 0; i <= m + 1; i++) {
            dp[i][0][0] = 1;
            dp[i][n + 1][0] = 1;
        }
        for (int i = 0; i <= n + 1; i++) {
            dp[0][i][0] = 1;
            dp[m + 1][i][0] = 1;
        }
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i + 1][j][k - 1] + dp[i][j - 1][k - 1] + dp[i][j + 1][k - 1]) % 1000000007;
                }
            }
        }
        int res = 0;
        for (int k = 1; k <= maxMove; k++) {
            res = (int) ((res + dp[startRow + 1][startCol + 1][k]) % 1000000007);
        }
        return res;
    }
}
