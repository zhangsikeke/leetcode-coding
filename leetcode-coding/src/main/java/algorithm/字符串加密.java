package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字符串加密 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            nums[0] = 1;
            int tmp = nums[0];
            int add = 2;
            for (int i = 1; i < num; i++) {
                tmp += add;
                add++;
                nums[i] = tmp;
            }

            List<Integer> list = new ArrayList<Integer>();
            List<Integer> tmpList = new ArrayList<Integer>();
            for (int i : nums) {
                list.add(i);
                System.out.print(i + " ");
            }
            System.out.println();
            while (list.size() >= 1) {
                int len = list.size();
                for (int i = 1; i < len; i++) {
                    System.out.print(list.get(i) - 1 + " ");
                    tmpList.add(list.get(i) - 1);

                    if (i == len - 1) {
                        System.out.println();
                    }
                }

                list.clear();
                list.addAll(tmpList);
                tmpList.clear();
            }
        }
    }
}
