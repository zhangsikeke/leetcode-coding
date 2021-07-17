package 练习202107月份;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟-分别遍历上下两种方向然后再组装
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A5_498_对角线遍历 {
    public int[] findDiagonalOrder(int[][] nums) {
        boolean flg = false;
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> listUp = new ArrayList<>();
        List<List<Integer>> listDown = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            print(nums, i, 0, true, tmp);
            listUp.add(new ArrayList<>(tmp));
            tmp.clear();
            if (i == nums.length - 1) {
                flg = true;
            }
        }
        for (int j = flg ? 2 : 1; j < nums[0].length; j += 2) {
            print(nums, nums.length - 1, j, true, tmp);
            listUp.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        flg = false;
        for (int i = 1; i < nums[0].length; i += 2) {
            print(nums, 0, i, false, tmp);
            listDown.add(new ArrayList<>(tmp));
            tmp.clear();
            if (i == nums[0].length - 1) {
                flg = true;
            }
        }
        for (int j = flg ? 2 : 1; j < nums.length; j += 2) {
            print(nums, j, nums[0].length - 1, false, tmp);
            listDown.add(new ArrayList<>(tmp));
            tmp.clear();
        }

        int[] res = new int[nums.length * nums[0].length];
        int idx = 0;
        for (int i = 0; i < listUp.size(); i++) {
            List<Integer> s = listUp.get(i);
            for (Integer integer : s) {
                res[idx] = integer;
                idx++;
            }
            if (i < listDown.size()) {
                s = listDown.get(i);
                for (Integer integer : s) {
                    res[idx] = integer;
                    idx++;
                }
            }
        }
        return res;
    }

    private void print(int[][] nums, int x, int y, boolean up, List<Integer> tmp) {
        if (x >= 0 && x < nums.length && y >= 0 && y < nums[0].length) {
            tmp.add(nums[x][y]);
        }
        if (up) {
            if (x - 1 >= 0 && x < nums.length && y >= 0 && y + 1 < nums[0].length) {
                print(nums, x - 1, y + 1, up, tmp);
            }
        } else {
            if (x >= 0 && x + 1 < nums.length && y - 1 >= 0 && y < nums[0].length) {
                print(nums, x + 1, y - 1, up, tmp);
            }
        }
    }
}
