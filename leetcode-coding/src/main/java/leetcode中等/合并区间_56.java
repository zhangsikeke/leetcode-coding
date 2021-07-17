package leetcode中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_56 {

    public static void main(String[] args) {
        int[][] res = merge(new int[][] {{2, 3}, {4, 5}, {6, 7}, {1, 10}});
        for (int[] is : res) {
            System.out.println(is[0] + " " + is[1]);
        }
    }

    public static int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = nums[i][0];
            int r = nums[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                list.add(new int[] {l, r});
            }else {
                int cu = list.get(list.size() - 1)[1];
                list.get(list.size() - 1)[1] = Math.max(cu, r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
