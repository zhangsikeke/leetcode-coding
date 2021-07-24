package 二分查找;

/**
 * @author: keke
 * @date: 2021/7/24 13:28
 */
public class A_69_X的平方根 {
    /**
     * 二分查找求对数
     *
     * @param target
     * @return
     */
    public static int midSearchSqort(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        long left = 0;
        long right = target;
        long mid = 0;
        while (left < right) {
            if (mid * mid <= target && (mid + 1) * (mid + 1) > target)
                return (int) mid;
            if (mid * mid > target) {
                right = mid;
                mid = (left + right) / 2;
            } else if (mid * mid < target) {
                left = mid;
                mid = (left + right) / 2;
            }
        }
        return (int) mid;
    }
}
