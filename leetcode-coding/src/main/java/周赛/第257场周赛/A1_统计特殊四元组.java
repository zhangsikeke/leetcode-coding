package 周赛.第257场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/8/27 23:41
 */
public class A1_统计特殊四元组 {
    public static void main(String[] args) {
        A1_统计特殊四元组 test = new A1_统计特殊四元组();
        System.out.println(test.countQuadruplets(new int[]{1,1,1,3,5}));
    }



    public int countQuadruplets1(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-3;i++) {
            for(int j=i+1;j<nums.length-2;j++) {
                for(int k=i+2;k<nums.length-1;k++) {
                    for(int z=i+3;z<nums.length;z++) {
                        int a = i;
                        int b = j;
                        int c = k;
                        int d = z;
                        if (nums[a] + nums[b] + nums[c] == nums[d] && a < b && b < c && c < d) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int countQuadruplets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        combination(nums, 4, 0, list, res);
        int count = 0;
        for (List<Integer> tmpList : list) {
            int a = tmpList.get(0);
            int b = tmpList.get(1);
            int c = tmpList.get(2);
            int d = tmpList.get(3);
            if (nums[a] + nums[b] + nums[c] == nums[d] && a < b && b < c && c < d) {
                count++;
            }
        }
        System.out.println(list);
        return count;
    }

    public static void combination(int[] nums, int k, int step, List<List<Integer>> list, List<Integer> res) {
        if (res.size() == k) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = step; i < nums.length; i++) {
            res.add(i);
            combination(nums, k, i + 1, list, res);
            res.remove(res.size() - 1);
        }
    }
}