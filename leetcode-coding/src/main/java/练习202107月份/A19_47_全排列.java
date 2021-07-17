package 练习202107月份;

import java.util.*;

/**
 * 回溯
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A19_47_全排列 {
    public static void main(String[] args) {
        List<List<Integer>> res = new A19_47_全排列().permuteUnique(new int[]{1, 1, 2});
        System.out.println(res);
    }

    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        dfs(nums);
        return list;
    }

    private void dfs(int[] nums) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            res.add(nums[i]);
            dfs(nums);
            res.remove(res.size() - 1);
            visited[i] = false;
        }
    }
}
