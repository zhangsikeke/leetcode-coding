package 排序系列;

public class 快速排序 {

    /**
     * 1.定义左扫描点起始位i和右扫描起始位j，设置左扫描起始位为基准位 <br>
     * 2.当i<j时，从右向左找一个比基准位小的数，从左向右找一个比基准位大的数，交换这两个数 <br>
     * 3.交换结束后将基准位与i==j位置交换 4.递归左半边，递归右半边 <br>
     * 
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        // 低位起始扫描位置
        int i = low;
        // 高位起始扫描位置
        int j = high;
        // 以第一个元素为基准位
        int base = nums[low];

        while (i < j) {
            // 因为基准数设置为第一个元素，即最左边的元素，所以每次必须从右边开始探测
            // 从右向左扫描找到小于基准数的位置停下来
            while (i < j && base <= nums[j]) {
                j--;
            }
            // 从左向右扫描找到大于基准数的位置停下来
            while (i < j && base >= nums[i]) {
                i++;
            }
            // 当i<j时说明i比标准元素大，j表标准元素小，将i放到基准元素右侧，j放到基准元素左侧
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // 将基准位数据调整到i和j相遇的位置，将i=j的位置元素调整到原来基准位
        nums[low] = nums[i];
        nums[i] = base;
        // 继续分治
        // 递归调用左半数组
        quickSort(nums, low, j - 1);
        // 递归调用右半数组
        quickSort(nums, j + 1, high);
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10, 5, 1, 45, 200, 78, 9, 0};
        print(nums);
        quickSort(nums, 0, nums.length - 1);
        print(nums);
    }

}
