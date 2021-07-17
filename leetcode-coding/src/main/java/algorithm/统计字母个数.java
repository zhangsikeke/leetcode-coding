package algorithm;

import java.util.Scanner;

public class 统计字母个数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            count(str);

        }
    }

    public static void count(String str) {
        // 英文字符，空格字符，数字字符，其他字符的个数
        char[] cs = str.toCharArray();
        int alphaNum = 0;
        int emptyNum = 0;
        int numNum = 0;
        int otherNum = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                alphaNum++;
            else if (c == ' ')
                emptyNum++;
            else if (c >= '0' && c <= '9')
                numNum++;
            else
                otherNum++;
        }

        System.out.println(alphaNum);
        System.out.println(emptyNum);
        System.out.println(numNum);
        System.out.println(otherNum);
    }

}
