package 练习202107月份;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 动态规划
 *
 * @author: keke
 * @date: 2021/7/10 22:24
 */
public class A14_75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new A14_75_颜色分类().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, (a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
}
