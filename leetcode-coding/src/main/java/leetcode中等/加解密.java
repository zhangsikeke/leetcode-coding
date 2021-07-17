
package leetcode中等;

import java.util.Scanner;

public class 加解密 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(encode(str1));
            System.out.println(decode(str2));
        }
        scanner.close();

    }

    public static String encode(String str) {
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    sb.append("A");
                } else {
                    sb.append((char)((int)c - 31));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    sb.append("a");
                } else {
                    sb.append((char)((int)c + 33));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '9') {
                    sb.append("0");
                } else {
                    sb.append((char)((int)c + 1));
                }
            }
        }
        return sb.toString();
    }

    public static String decode(String str) {
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    sb.append("Z");
                } else {
                    sb.append((char)((int)c - 33));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    sb.append("z");
                } else {
                    sb.append((char)((int)c + 31));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '0') {
                    sb.append("9");
                } else {
                    sb.append((char)((int)c - 1));
                }
            }
        }
        return sb.toString();
    }

}