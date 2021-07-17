package 练习202107月份;

/**
 * DFS
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A2_200_岛屿数量 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果岛屿面积大于0，说明有一个岛屿
                    count += dfs(grid, i, j) > 0 ? 1 : 0;
                }
            }
        }
        return count;
    }

    // 计算一个岛屿陆地面积
    private int dfs(char[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == '0') return 0;
        // 遍历后设置为0
        g[i][j] = '0';
        // 返回岛屿面积
        return 1 + dfs(g, i - 1, j) + dfs(g, i + 1, j) + dfs(g, i, j - 1) + dfs(g, i, j + 1);
    }
}
