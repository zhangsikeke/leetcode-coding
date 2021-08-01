package 练习202108月份;

import java.util.*;

/**
 * DFS
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A2_1905_统计子岛屿 {
    public static void main(String[] args) {
        A2_1905_统计子岛屿 test = new A2_1905_统计子岛屿();
        int res = test.countSubIslands(new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}});
        System.out.println(res);
    }

    // 记录数据2中岛屿和数据1中岛屿重复的数据陆地编号
    private Map<Integer, Integer> map = new HashMap<>();
    // 记录岛屿中每块陆地的所在岛屿的编号
    Map<String, Integer> landPosMap1 = new HashMap<>();
    Map<String, Integer> landPosMap2 = new HashMap<>();

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        // 记录每个岛屿的坐标
        List<Set<String>> list1 = getLands(grid1, landPosMap1, 1);
        List<Set<String>> list2 = getLands(grid2, landPosMap2, 2);
        int total = 0;
        int land2Index = 0;
        for (Set<String> land2 : list2) {
            // 查找在第一块陆地中是否有对应的坐标的岛屿
            if (map.containsKey(land2Index)) {
                int land1Index = map.get(land2Index);
                // 榄段land2是否land1的子岛屿
                if (land1ContainsLand2(list1.get(land1Index), land2)) {
                    total++;
                }
            }
            land2Index++;
        }
        return total;
    }

    private boolean land1ContainsLand2(Set<String> land1, Set<String> land2) {
        for (String s : land2) {
            if (!land1.contains(s)) {
                return false;
            }
        }
        return land1.size() > 0;
    }

    public List<Set<String>> getLands(int[][] grid, Map<String, Integer> landPosMap, int dataIndex) {
        List<Set<String>> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Set<String> currentPosIndexSet = new HashSet<>();
                    dfs(grid, i, j, currentPosIndexSet, total, landPosMap, dataIndex);
                    total++;
                    list.add(currentPosIndexSet);
                }
            }
        }
        return list;
    }

    // 获取一个岛屿的坐标
    private void dfs(int[][] g, int i, int j, Set<String> currentPosIndexSet, int pos, Map<String, Integer> landPosMap, int dataIndex) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0) return;
        // 遍历后设置为0
        g[i][j] = 0;
        String key = i + ":" + j;
        currentPosIndexSet.add(key);
        landPosMap.put(key, pos);
        if (landPosMap1.containsKey(key)) {
            map.put(pos, landPosMap1.get(key));
        }
        // 返回岛屿面积
        dfs(g, i - 1, j, currentPosIndexSet, pos, landPosMap, dataIndex);
        dfs(g, i + 1, j, currentPosIndexSet, pos, landPosMap, dataIndex);
        dfs(g, i, j - 1, currentPosIndexSet, pos, landPosMap, dataIndex);
        dfs(g, i, j + 1, currentPosIndexSet, pos, landPosMap, dataIndex);
    }
}
