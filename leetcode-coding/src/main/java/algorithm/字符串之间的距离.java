package algorithm;

import java.util.Scanner;

public class 字符串之间的距离 {
    public static void main(String[] args) {

        字符串之间的距离 m = new 字符串之间的距离();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(m.search(str1, str2));
        }

    }

    /**
     * 1.dp[i][j] 表示a的字符串前i位和b的字符串前j位改动的次数<br>
     * 2.i=0时,需要改动j次，j=0时需要改动i次<br>
     * 3.a[i-1] = b[j-]时不需要改动，dp[i][j] = dp[i-1][j-1]<br>
     * 4.当a[i-1]!=b[j-1]时有三种改法，删除a[i],删除b[j],改成一样，既dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1<br>
     * 
     * @param str
     */
    public int search(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int[][] dp = new int[as.length + 1][bs.length + 1];
        for (int j = 0; j <= bs.length; j++)
            dp[0][j] = j;
        for (int i = 0; i <= as.length; i++)
            dp[i][0] = i;

        for (int i = 1; i <= as.length; i++) {
            for (int j = 1; j <= bs.length; j++) {
                if (as[i - 1] == bs[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[as.length][bs.length];
    }
}
