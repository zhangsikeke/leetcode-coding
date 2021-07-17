package 回溯系列;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        sort(nums, new ArrayList<Integer>());
    }

    /**
     * 所有排列
     * 
     * @param nums
     * @param res
     */
    public static void sort(int[] nums, List<Integer> res) {
        if (res.size() == nums.length) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 去除重复的数，否则会有[1,1,1]这样的组合
            if (res.contains(nums[i])) {
                continue;
            }
            res.add(nums[i]);
            sort(nums, res);
            res.remove(res.size() - 1);
        }
    }
}
