package 练级202109月份;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: keke
 * @date: 2021/9/14 23:22
 */
public class A_524_通过删除字母匹配到字典里最长单词 {
    public static void main(String[] args) {
        Stream.<String>of("ale", "apple", "monkey", "plea").toArray();
        System.out.println(findLongestWord("abpcplea", Stream.<String>of("ale","apple","monkey","plea").collect(Collectors.toList())));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        List<String> list = new ArrayList<>();
        for (String str : dictionary) {
            int pos = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = str.charAt(pos);
                char curCh = s.charAt(i);
                if (ch == curCh) {
                    pos++;
                }
                if (pos == str.length()) {
                    list.add(str);
                    break;
                }
            }
        }
        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        return list.isEmpty() ? "" : list.get(0);
    }
}
