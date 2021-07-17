
package leetcode困难;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 单词倒排 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            List<String> list = doWith(str);
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i) + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
        scanner.close();
        
        doWith("I am a student");//输出student a am I

    }

    public static List<String> doWith(String str) {
        List<String> list = new ArrayList<>();
        int len = str.length();
        int start = 0;
        int end = 0;
        while (end <= len) {

            if (end == len) {
                if (start < len)
                    list.add(str.substring(start, end));
                break;
            }
            // 西安找到一个合理的char
            if (!isNeedChar(str.charAt(start))) {
                start++;
                end++;
                continue;
            }
            if (start == end || isNeedChar(str.charAt(end))) {
                end++;
                continue;
            }

            if (!isNeedChar(str.charAt(end))) {
                list.add(str.substring(start, end));
                start = end;
            }

        }

        return list;
    }

    public static boolean isNeedChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}