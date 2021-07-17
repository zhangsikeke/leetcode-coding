package leetcode困难;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 排列 {

    public static void main(String[] args) {
         int[] nums = new int[] {1, 2, 3};
         List<Integer> res = new ArrayList<>();
         dfs(nums, res);

//        String[] reStrings = permutation("dkjphedy");
//        for (String string : reStrings) {
//            System.out.println(string);
//        }
    }

    public static void dfs(int[] nums, List<Integer> res) {
        if (res.size() == nums.length) {
            show(res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res.contains(nums[i])) {
                continue;
            }
            res.add(nums[i]);
            dfs(nums, res);
            res.remove(res.size() - 1);
        }
    }

    public static void show(List<Integer> res) {
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static String[] permutation(String s) {
        char[] cs = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Set<String> filter = new HashSet<>();
        dfs(cs, list, filter, res);
        return list.toArray(new String[list.size()]);
    }

    public static void dfs(char[] cs, List<String> list, Set<String> filter, List<Integer> res) {
        if (res.size() == cs.length) {
            String tmpStr = "";
            for (Integer i : res) {
                tmpStr += cs[i];
            }
            if (!filter.contains(tmpStr)) {
                list.add(tmpStr);
                filter.add(tmpStr);
            }
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (res.contains(i)) {
                continue;
            }
            res.add(i);
            dfs(cs, list, filter, res);
            res.remove(res.size() - 1);
        }
    }
}
