package leetcode中等;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.https://leetcode-cn.com/problems/combination-sum/
 * 
 * @author keke
 * @date 2020/09/09
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(nums, 7);
        for (List<Integer> ls : list) {
            System.out.println(ls);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(candidates, target, 0, list, res);
        return list;
    }

    public static void dfs(int[] nums, int sum, int step, List<List<Integer>> list, List<Integer> res) {
        if (sum < 0) {
            return;
        }
        // 将合适的条件加入结果集
        if (0 == sum) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]); // 选择
            sum -= nums[i];   // 选择
            // 注意：由于可以复用元素，所以step没有+1
            dfs(nums, sum, i, list, res);
            res.remove(res.size() - 1); // 回溯撤销
            sum += nums[i]; // 回溯撤销
        }

    }

}
