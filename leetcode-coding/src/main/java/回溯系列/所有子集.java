package 回溯系列;

import java.util.ArrayList;
import java.util.List;

public class 所有子集 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        help(nums, 0, new ArrayList<Integer>());
    }

    /**
     * 所有子集
     * 
     * @param nums
     * @param res
     */
    public static void help(int[] nums, int step, List<Integer> res) {
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            // 输出子集
            System.out.println(res);
            help(nums, i + 1, res);
            res.remove(res.size() - 1);
        }
    }
}
