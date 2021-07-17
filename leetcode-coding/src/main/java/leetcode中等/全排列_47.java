package leetcode中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        boolean[] vis = new boolean[nums.length];
        // 从小到大排序方便剪枝
        Arrays.sort(nums);
        helpFunction(nums, vis, list, res);
        return list;
    }

    public static void helpFunction(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> res) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 访问过跳过
            // i和i-1相同，i-1没访问过跳过当前，让访问i-1
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            res.add(nums[i]);
            helpFunction(nums, visited, list, res);
            visited[i] = false;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[] {1, 1, 2});
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

}
