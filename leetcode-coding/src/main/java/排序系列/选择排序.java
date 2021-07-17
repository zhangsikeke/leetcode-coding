package 排序系列;

public class 选择排序 {
    /**
     * 比较排序/选择排序<br>
     * 时间复杂度o(n2)，空间复杂度o(1) 说明：<br>
     * 1.循环每个元素<br>
     * 2.和剩下每个元素逐一比较，大于或小于就交换位置<br>
     * 
     * @param nums
     */
    public static void compareSort(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
}
