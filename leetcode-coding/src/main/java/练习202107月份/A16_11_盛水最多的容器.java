package 练习202107月份;

/**
 * 双指针
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A16_11_盛水最多的容器 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            tmp = Math.abs(tmp);
            max = Math.max(max, tmp);
            if (height[right] >= height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
