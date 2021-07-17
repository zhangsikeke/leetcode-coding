package leetcode中等;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 */
public class 全排列_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helpFunction(nums, visited, list, res);
        return list;
    }

    public static void helpFunction(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> res) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            res.add(nums[i]);
            visited[i] = true;
            helpFunction(nums, visited, list, res);
            res.remove(res.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[] {1, 2, 3});
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

}
