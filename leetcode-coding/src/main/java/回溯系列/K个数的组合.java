package 回溯系列;

import java.util.ArrayList;
import java.util.List;

public class K个数的组合 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        sort(nums, 3, 0, new ArrayList<Integer>());
    }

    /**
     * k个数的组合
     * 
     * @param nums
     * @param k
     * @param step
     * @param res
     */
    public static void sort(int[] nums, int k, int step, List<Integer> res) {
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            if (res.size() == k) {
                System.out.println(res);
            }
            sort(nums, k, i + 1, res);
            res.remove(res.size() - 1);
        }
    }

}
