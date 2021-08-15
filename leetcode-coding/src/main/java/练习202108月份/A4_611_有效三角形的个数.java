package 练习202108月份;

import java.util.Arrays;

/**
 * @author: keke
 * @date: 2021/8/4 20:27
 */
public class A4_611_有效三角形的个数 {
    public static void main(String[] args) {
        A4_611_有效三角形的个数 test = new A4_611_有效三角形的个数();
        int total = test.triangleNumber(new int[]{16, 70, 16, 36, 17, 39, 44, 72, 25, 88, 18, 22, 20, 84, 18, 66, 71, 74, 87, 59, 48, 91, 52, 15, 92, 29, 85, 21, 10, 34, 86, 68, 10, 27, 3, 42, 49, 48, 18, 15, 6, 39, 61, 28, 19, 52, 60, 8, 37, 32, 71, 82, 54, 38, 47, 33, 10, 64, 52, 71, 39, 63, 64, 79, 86, 47, 16, 72, 55, 17, 35, 88, 74, 93, 10, 59, 3, 64, 95, 91, 61, 28, 63, 23, 49, 6, 24, 47, 41, 88, 96, 23, 90, 53, 84, 3, 35, 23, 3, 17});
        System.out.println(total);
    }


    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                int pos = j;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] + nums[j] > nums[mid]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                total += pos - j;
            }
        }
        return total;
    }
}
