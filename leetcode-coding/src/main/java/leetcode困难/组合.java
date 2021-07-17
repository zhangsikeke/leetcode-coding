package leetcode困难;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, res);
    }

    public static void dfs(int[] nums, int step, List<Integer> res) {
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            show(res);
            dfs(nums, i+1, res);
            res.remove(res.size() - 1);
        }
    }

    public static void show(List<Integer> res) {
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
