package 周赛.第60周;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/9/5 0:16
 */
public class A2_找到所有的农场组 {

    private int xRightBottom = Integer.MIN_VALUE;
    private int yRightBottom = Integer.MIN_VALUE;

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    init();
                    int res = dfs(land, i, j);
                    if (res > 0) {
                        list.add(new int[]{i, j, xRightBottom, yRightBottom});
                    }
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private void init() {
        xRightBottom = Integer.MIN_VALUE;
        yRightBottom = Integer.MIN_VALUE;
    }

    private int dfs(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0) return 0;

        g[i][j] = 0;
        if (i > xRightBottom) {
            xRightBottom = i;
        }
        if (j > yRightBottom) {
            yRightBottom = j;
        }
        return 1 + dfs(g, i - 1, j) + dfs(g, i + 1, j) + dfs(g, i, j - 1) + dfs(g, i, j + 1);
    }
}
