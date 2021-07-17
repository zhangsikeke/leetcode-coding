package algorithm;

import java.util.Scanner;

public class 按字节截取字符串 {
    public static void main(String[] args) {

        按字节截取字符串 m = new 按字节截取字符串();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            int num =Integer.valueOf(strs[1]);
            System.out.println(m.cutStr(strs[0], num));
        }

        // String string = "我ABC汉DEF";
        //
        // System.out.println(m.cutStr(string, 6));

    }

    public String cutStr(String str, int len) {
        int sLen = str.length();
        int[] nums = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            String s = str.substring(i, i + 1);
            nums[i] = s.getBytes().length;
        }
        int sum = 0;
        for (int i : nums) {
            if (sum + i <= len) {
                sum += i;
            }
        }
        return new String(str.getBytes(), 0, sum);
    }

}
