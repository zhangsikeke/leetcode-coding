package leetcode中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字符组合_17 {
    static final Map<Character, String> phoneMap = new HashMap<Character, String>() {
        private static final long serialVersionUID = 1L;

        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public static List<String> letterCombinations(String digits) {
        List<String> reList = new ArrayList<>();
        if (digits.isEmpty()) {
            return reList;
        }
        backTrace(digits, 0, reList, new StringBuilder());
        return reList;
    }

    public static void backTrace(String str, int index, List<String> reList, StringBuilder sb) {
        if (index >= str.length()) {
            reList.add(sb.toString());
        } else {
            char c = str.charAt(index);
            String tmpStr = phoneMap.get(c);
            for (int i = 0; i < tmpStr.length(); i++) {
                sb.append(tmpStr.charAt(i));
                backTrace(str, index + 1, reList, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
