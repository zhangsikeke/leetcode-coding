package 深度搜索;

import java.util.*;

/**
 * dfs+回溯
 *
 * @author: keke
 * @date: 2021/7/24 17:52
 */
public class A_LCP_07_传递信息 {
    public static void main(String[] args) {
        A_LCP_07_传递信息 test = new A_LCP_07_传递信息();
        int[][] nums = new int[][]{{0, 1}, {0, 2}, {2, 1}, {1, 2}, {1, 0}, {2, 0}};
        int res = test.numWays(3, nums, 5);
        System.out.println(res);
    }

    private Map<Integer, Set<Integer>> dataMap = new HashMap<>();

    public int numWays(int n, int[][] relation, int k) {
        // 存储每个顶点可到达的节点
        for (int[] ints : relation) {
            int p1 = ints[0];
            int p2 = ints[1];
            if (!dataMap.containsKey(p1)) {
                dataMap.put(p1, new HashSet<>());
            }
            dataMap.get(p1).add(p2);
        }
        return dfs(n, 0, relation, k, new ArrayList<>());
    }

    private int dfs(int n, int start, int[][] relation, int k, List<Integer> res) {
        // 走满K步返回
        if (k == 0) {
            // 走满K步后如果到达最后一个位置说明信息传递到了，有效路径+1
            if (start == n - 1) {
                res.add(n - 1);
                // res为一条有效路径可在此保存
                res.remove(res.size() - 1);
                return 1;
            }
            return 0;
        }
        int total = 0;
        if (dataMap.containsKey(start)) {
            Set<Integer> list = dataMap.get(start);
            // 步数减1
            k--;
            for (Integer p2 : list) {
                res.add(start);
                total += dfs(n, p2, relation, k, res);
                res.remove(res.size() - 1);
            }
        }
        return total;
    }
}
