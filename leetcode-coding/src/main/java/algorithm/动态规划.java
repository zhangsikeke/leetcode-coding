package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 动态规划 {
    /**
     * <p>
     * -动态规划求解01背包
     * </p>
     * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]} 前i件物品放到容量为v的背包中的价值
     *
     * @param w 商品体积
     * @param v 商品价值
     * @param p 背包容量
     * @return 返回选中物品的index
     */
    public static List<Integer> packageGoods(int w[], int v[], int p) {
        List<Integer> reIndexs = new ArrayList<>();
        int n = w.length;
        int[][] c = new int[n + 1][p + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                if (j >= w[i - 1])
                    c[i][j] = Math.max(c[i - 1][j - w[i - 1]] + v[i - 1], c[i - 1][j]);
                else
                    c[i][j] = c[i - 1][j];
            }
        }
        // 筛选选中的物品
        int m = p;
        for (int i = w.length - 1; i >= 0; i--) {
            if (c[i + 1][m] > c[i][m]) {
                reIndexs.add(i);
                m -= w[i];
            }
        }
        return reIndexs;
    }
}
