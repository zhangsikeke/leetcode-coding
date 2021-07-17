package algorithm;

/**
 * 二分查找
 */
public class 二分查找 {

    /**
     * 二分查找<br>
     * 关键点： <br>
     * 1.包含左右边界 <br>
     * 2.中间值mid = left+(right-left)/2<br>
     *
     * @param sortArr
     * @param target
     * @return
     */
    public static int midSearch(int[] sortArr, int target) {
        int left = 0;
        int right = sortArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortArr[mid] > target) {
                right = mid - 1;
            } else if (sortArr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找求对数
     *
     * @param target
     * @return
     */
    public static int midSearchSqort(int target) {
        int left = 1;
        int right = target / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == target) {
                return mid;
            } else if (target > (mid - 1) * (mid - 1) && target < (mid + 1) * (mid + 1)) {
                return mid;
            }
            if (mid * mid > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 8, 50, 100, 200};
        System.out.println(midSearch(arr, 50));
    }
}
