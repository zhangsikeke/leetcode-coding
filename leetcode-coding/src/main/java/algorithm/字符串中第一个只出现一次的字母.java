package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 字符串中第一个只出现一次的字母 {
    public static void main(String[] args) {

        字符串中第一个只出现一次的字母 m = new 字符串中第一个只出现一次的字母();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            m.search(string);
        }

    }

    public void search(String str) {
        char[] cs = str.toCharArray();
        int len = cs.length;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(cs[i])) {
                map.put(cs[i], 2);
            } else {
                map.put(cs[i], 1);
            }
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }

        System.out.println("-1");
    }

}
