package 专项练习.树;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/5/23 20:33
 */
public class 二维数组 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {2, 3, 4, 5, 6, 7, 8},
                {3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 10},
                {5, 6, 7, 8, 9, 10, 11}
        };
        new 二维数组().split(nums, 3, 3);
    }

    public void split(int[][] nums, int m, int n) {
        int x = nums.length;
        int y = nums[0].length;
        int rowStart = 0;
        int colStart = 0;
        while (rowStart + m <= x || colStart + n <= y) {
            if (colStart + n > y) {
                System.out.println("---换行");
                rowStart += 1;
                colStart = 0;
                continue;
            }
            if (rowStart + m > x) {
                break;
            }
            printArray(nums, rowStart, colStart, m, n);
            colStart += 1;
        }
    }

    private static int index = 1;

    private void printArray(int[][] nums, int x, int y, int m, int n) {
        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------" + index);
        index++;
    }


}
