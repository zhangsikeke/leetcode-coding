package 练习202108月份;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/8/27 23:24
 */
public class A27_295_数据流的中位数 {
    public static void main(String[] args) {
        A27_295_数据流的中位数 test = new A27_295_数据流的中位数();
        test.addNum(6);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test.findMedian());
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(6);
        System.out.println(test.findMedian());
        test.addNum(5);
        System.out.println(test.findMedian());
        test.addNum(0);
        System.out.println(test.findMedian());
        test.addNum(6);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
        test.addNum(1);
        System.out.println(test.findMedian());
        test.addNum(0);
        System.out.println(test.findMedian());
        test.addNum(0);
        System.out.println(test.findMedian());
    }

    private List<Integer> list = new ArrayList<>();


    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int pos = search(list, num);
        int tmpNum = list.get(pos);
        List<Integer> tmpList = new ArrayList<>();
        if (pos == 0) {
            if (num <= tmpNum) {
                list.add(0, num);
            } else {
                list.add(1, num);
            }
        } else if (pos == list.size() - 1) {
            if (num <= tmpNum) {
                list.add(list.size() - 1, num);
            } else {
                list.add(num);
            }
        } else {
            if (num <= tmpNum) {
                list.add(pos, num);
            } else {
                list.add(pos + 1, num);
            }
        }
    }

    public double findMedian() {
        int len = list.size();
        if (len == 0) {
            return 0.0;
        }
        if (len % 2 == 0) {
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2.0;
        } else {
            return list.get(len / 2);
        }
    }

    /**
     * 找到最接近target的数
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