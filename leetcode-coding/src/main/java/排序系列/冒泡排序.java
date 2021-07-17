package 排序系列;

public class 冒泡排序 {
    /**
     * 冒泡排序<br>
     * 时间复杂度o(n2)，最好时间复杂度o(n)空间复杂度o(1)
     * 
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }
}
