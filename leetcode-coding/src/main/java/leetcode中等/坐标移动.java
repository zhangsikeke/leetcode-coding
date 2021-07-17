
package leetcode中等;

import java.util.Scanner;

public class 坐标移动 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(";");
            for (String s : strs) {
                doWith(s);
            }
            System.out.println(x + "," + y);

        }
        scanner.close();
    }

    public static int x;
    public static int y;

    public static void doWith(String str) {
        if("".equals(str)) {
            return;
        }
        String way = str.substring(0, 1);
        int distance = 0;
        int start = 1;
        int len = str.length();
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                distance = Integer.parseInt(str.substring(start, i));
                if (way.equals("A")) {
                    x -= distance;
                } else if (way.equals("D")) {
                    x += distance;
                } else if (way.equals("W")) {
                    y += distance;
                } else if (way.equals("S")) {
                    y -= distance;
                }

                way = c + "";
                start = i + 1;

            }
        }
        
        distance = Integer.parseInt(str.substring(start));
        if (way.equals("A")) {
            x -= distance;
        } else if (way.equals("D")) {
            x += distance;
        } else if (way.equals("W")) {
            y += distance;
        } else if (way.equals("S")) {
            y -= distance;
        }

    }

}