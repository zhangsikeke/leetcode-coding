package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 回溯算法团灭全排列组合子集 {
    public static void main(String[] args) {
        System.out.println("====数组中和为m的所有子集==========");
        List<Integer> res4 = new ArrayList<>();
        int[] nums1= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int sum2 = 6;
        sonNum(nums1, sum2, 0, res4);

        System.out.println("====数组中和为m的所有子集(可复用元素)==========");
        List<List<Integer>> list10 = new ArrayList<>();
        List<Integer> res10 = new ArrayList<>();
        int[] nums10 = {2, 3, 4, 5, 6};
        int sum10 = 6;
        sonSum2(nums10, sum10, 0, list10, res10);
        for (List<Integer> ls : list10) {
            System.out.println(ls);
        }

        System.out.println("====数组中的所有子集==========");
        int[] nums = {1, 2, 3};
        int sum = 10;
        List<Integer> res = new ArrayList<>();
        allSon(nums, sum, 0, res);

        System.out.println("====数组中的所有排列========");
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        backtrack(nums, list1, res1);
        for (List<Integer> ls : list1) {
            System.out.println(ls);
        }
        System.out.println("====数组中k个数字的所有组合====");
        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        combination(nums, 2, 0, list2, res2);
        for (List<Integer> ls : list2) {
            System.out.println(ls);
        }
    }

    /**
     * 求取数组中所有子集元素，其相加之和等于m
     * 
     * @param nums
     * @param m
     * @param step
     * @param list
     */
    public static void sonNum(int[] nums, int m, int step, List<Integer> res) {
        if (step >= nums.length)
            return;
        if (m == 0) {
            System.out.println(res);
            return;
        }
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            m -= nums[i];
            sonNum(nums, m, i+1, res);
            res.remove(res.size() - 1);
            m += nums[i];
        }
    }

    /**
     * 求取数组中所有子集元素，其相加之和等于sum,可复用元素
     * 
     * @param nums
     * @param sum
     * @param step
     * @param list
     * @param res
     */
    public static void sonSum2(int[] nums, int sum, int step, List<List<Integer>> list, List<Integer> res) {
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
            sum -= nums[i]; // 选择
            // 注意：由于可以复用元素，所以step没有+1
            sonSum2(nums, sum, i, list, res);
            res.remove(res.size() - 1); // 回溯撤销
            sum += nums[i]; // 回溯撤销
        }

    }

    /**
     * 所有子集<br>
     *
     * 
     * @param nums
     * @param m
     * @param step
     * @param list
     */
    public static void allSon(int[] nums, int m, int step, List<Integer> res) {
        if (step >= nums.length)
            return;
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            System.out.println(res);
            allSon(nums, m, i+1, res);
            res.remove(res.size() - 1);
        }
    }

    /**
     * 全排列
     * 
     * @param nums
     * @param track
     */
    public static void backtrack(int[] nums, List<List<Integer>> list, List<Integer> res) {
        // 触发结束条件
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (res.contains(nums[i]))
                continue;
            // 做选择
            res.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, list, res);
            // 取消选择
            res.remove(res.size() - 1);
        }
    }

    /**
     * nums 数组中k个数组的组合
     * 
     * @param nums
     * @param k
     * @param step
     * @param list
     * @param res
     */
    public static void combination(int[] nums, int k, int step, List<List<Integer>> list, List<Integer> res) {
        if (res.size() == k) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = step; i < nums.length; i++) {
            res.add(nums[i]);
            combination(nums, k, i+1, list, res);
            res.remove(res.size() - 1);
        }
    }

}
