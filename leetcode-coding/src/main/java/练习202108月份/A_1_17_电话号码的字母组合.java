package 练习202108月份;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs
 *
 * @author: keke
 * @date: 2021/8/1 14:40
 */
public class A_1_17_电话号码的字母组合 {
    private List<String> list;

    private static final Map<Character, String> digit_map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        dfs(0, digits, "");
        return list;
    }

    private void dfs(int pos, String digits, String tmp) {
        if (pos == digits.length()) {
            if (!"".equals(tmp)) {
                list.add(tmp);
            }
            return;
        }
        char current = digits.charAt(pos);
        String str = digit_map.get(current);
        for (int i = 0; i < str.length(); i++) {
            dfs(pos + 1, digits, tmp + str.substring(i, i + 1));
        }
    }

    public static void main(String[] args) {
        A_1_17_电话号码的字母组合 test = new A_1_17_电话号码的字母组合();
        List<String> list = test.letterCombinations("256");
        System.out.println(list);
    }
}
