package 练习202107月份;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * dfs+回溯+减枝
 *
 * @author: keke
 * @date: 2021/7/12 22:37
 */
public class A15_40_组合总和2 {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>());
        return list;
    }

    private void dfs(int pos, int[] candidates, int target, List<Integer> res) {
        if (target == 0) {
            list.add(new ArrayList<>(res));
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            res.add(candidates[i]);
            target -= candidates[i];
            dfs(i + 1, candidates, target, res);
            res.remove(res.size() - 1);
            target += candidates[i];
        }
    }
}
