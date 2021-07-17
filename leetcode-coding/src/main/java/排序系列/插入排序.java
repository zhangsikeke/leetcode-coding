package 排序系列;

public class 插入排序 {

    /**
     * <p>从1开始，将当前位置和前面位置逐个比较，将当前数冒泡到从左往右第一个比它大的数前面。跟冒泡排序一致
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for(int j=i;j>0;j--) {
                if(nums[j]<nums[j-1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10, 5, 1, 45, 200, 78, 9, 0};
        insertSort(nums);
        print(nums);
    }

}
