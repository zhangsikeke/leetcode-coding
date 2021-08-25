package 练习202108月份;

import java.util.*;

/**
 * 图遍历,所有路径，二维数组表示 i的连接节点
 *
 * @author: keke
 * @date: 2021/8/5 23:32
 */
public class A23_797_所有可能的路径 {
    public static void main(String[] args) {
        A23_797_所有可能的路径 test = new A23_797_所有可能的路径();
        List<List<Integer>> res = test.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {}, {4}, {}});
        System.out.println(res);
    }


    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        dfs(graph, 0, visited);
        return list;
    }

    public void dfs(int[][] graph, int pos, boolean[] visited) {
        if (visited[pos]) {
            return;
        }
        if (pos == graph.length - 1) {
            res.add(pos);
            list.add(new ArrayList<>(res));
            res.remove(res.size() - 1);
            return;
        }
        visited[pos] = true;
        res.add(pos);
        int[] target = graph[pos];
        for (int i = 0; i < target.length; i++) {
            dfs(graph, target[i], visited);
        }
        // 回溯
        res.remove(res.size() - 1);
        visited[pos] = false;
    }

    // bfs
    public List<List<Integer>> bfs(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(path);
        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            // 最后一个是当前访问的位置
            int currentPos = currentPath.get(currentPath.size() - 1);
            // 继续层级遍历
            for (int i : graph[currentPos]) {
                currentPath.add(i);
                if (i == graph.length - 1) {
                    res.add(new ArrayList<>(currentPath));
                } else {
                    queue.offer(new ArrayList<>(currentPath));
                }
                // 回溯
                currentPath.remove(currentPath.size() - 1);
            }
        }
        return res;
    }
}