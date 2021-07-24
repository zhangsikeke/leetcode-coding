package 二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: keke
 * @date: 2021/7/24 12:43
 */
public class A_658_找到K个最接近的元素 {
    /**
     * 解法一：排序法 超过15
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((a, b) -> a == b ? 0 : Math.abs(a - x) - Math.abs(b - x));
        List<Integer> res = list.subList(0, k);
        Collections.sort(res);
        return res;
    }

    /**
     * 解法二：二分搜索+remove仅仅超过5%的用户
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int findSize = 0;
        List<Integer> res = new ArrayList<>();
        while (findSize < k && list.size() > 0) {
            int index = search(list, x);
            findSize++;
            res.add(list.get(index));
            list.remove(index);
        }
        Collections.sort(res);
        return res;
    }

    /**
     * 找到最接近target的数
     *
     * @param list
     * @param target
     * @return
     */
    public static int search(List<Integer> list, int target) {
        if (target >= list.get(list.size() - 1)) {
            return list.size() - 1;
        }
        if (target <= list.get(0)) {
            return 0;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            }
        }
        return Math.abs(target - list.get(left)) < Math.abs(target - list.get(right)) ? left : right;
    }
}
