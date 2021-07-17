package leetcode困难;

public class 数组中的逆序对 {
    public int reversePairs(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    total++;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7, 5, 6, 4};
        System.out.println(new 数组中的逆序对().reversePairs(nums));
    }
}
