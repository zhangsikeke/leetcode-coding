
package leetcode中等;

import java.util.Scanner;

public class 排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            String[] strs = scanner.nextLine().split(" ");
            int flg = Integer.parseInt(scanner.nextLine());

            int[] nums = new int[num];
            int index = 0;
            for (int i : nums) {
                nums[index] = Integer.parseInt(strs[index]);
                index++;
            }
            sort(nums, flg);
            show(nums);

        }
        scanner.close();

    }

    public static void sort(int[] nums, int flg) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {

                if (flg == 0) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                    }
                } else {
                    if (nums[j] < nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                    }
                }

            }
        }
    }

    public static void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}