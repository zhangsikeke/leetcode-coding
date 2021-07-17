package 练习202107月份;

import java.util.*;

/**
 * dfs+环形链
 *
 * @author: keke
 * @date: 2021/7/7 19:42
 */
public class A10_207_课程表 {
    private boolean hasCircle = false;
    private List<List<Integer>> list;
    private int[] visited;

    public static void main(String[] args) {
        boolean res = new A10_207_课程表().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        boolean res1 = new A10_207_课程表().canFinish(2, new int[][]{{1, 0}, {0, 1}});
        boolean res2 = new A10_207_课程表().canFinish(7, new int[][]{{1, 0}, {0, 1}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}});
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses && !hasCircle; i++) {
            if (visited[i] == 0) {
                dfs(i);
                if (hasCircle)
                    break;
            }
        }
        return !hasCircle;

    }

    private void dfs(int p) {
        if (hasCircle) return;
        visited[p] = 1;
        List<Integer> tmpList = list.get(p);
        for (Integer i : tmpList) {
            if (visited[i] == 0) {
                dfs(i);
            } else if (visited[i] == 1) {
                hasCircle = true;
            }
        }
        visited[p] = 2;
    }
}
