package 排序系列;

public class 归并排序 {
    private static int index = 0;

    /**
     * 归并排序
     * 
     * @param nums
     * @param left  左边界(包含)
     * @param right 右边界(包含)
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        index++;
        // 分两半
        int mid = left + (right - left) / 2;
        System.out.println(index+",left-->" + left + "," + mid + "," + right);
        // 左边数组排序
        mergeSort(nums, left, mid);
        System.out.println(index+",right-->" + left + "," + mid + "," + right);
        // 右边数组排序
        mergeSort(nums, mid + 1, right);
        System.out.println(index+",merge-->" + left + "," + (mid + 1) + "," + right);
        // 将左右两个有序数组合并成一个有序数组
        merge(nums, left, mid + 1, right);
    }

    /**
     * 归并：将一个数组的[left-mid)和[mid-right]合并成一个有序的数组
     * 
     * @param nums
     * @param left  左起始位
     * @param mid   左边数组边界(不包含)
     * @param right 右边数组边界(包含)
     */
    public static void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int[] tmp = new int[right - left + 1];
        while (i < mid && j <= right)
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i < mid)
            tmp[k++] = nums[i++];

        while (j <= right)
            tmp[k++] = nums[j++];
        // System.out.print(left + "," + mid + "," + right + "=>");
        // print(tmp);
        for (int l = 0; l < tmp.length; l++) {
            nums[left + l] = tmp[l];
        }
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 7, 8, 3, 6, 9, 5, 20};
        // merger(nums, 0, 4, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        print(nums);
    }

}
