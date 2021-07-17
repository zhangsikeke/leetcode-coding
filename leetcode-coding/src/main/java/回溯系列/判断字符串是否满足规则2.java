package 回溯系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.jws.HandlerChain;

public class 判断字符串是否满足规则2 {
    public static void main(String[] args) {
        String str1 = "109something";
        str1 = "5hello5world7kkkkkkk";
        // System.out.println(getLength(str1));
        System.out.println(getLength(str1));
    }

    public static boolean getLength(String str) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(str, 0, res, list);
        System.out.println(res);
        System.out.println(list);
        return res.size() == 1;
    }

    private static void helper(String str, int index, List<List<Integer>> res, List<Integer> list) {
        System.out.println(str+",="+index);
        int len = str.length();
        if (index > len) {
            return;
        }
        if (len == index) {
            res.add(new ArrayList<>(list));
            return;
        }
        char ch = str.charAt(index);
        if (ch == '0' || !isNum(ch)) {
            return;
        }
        int count = 0;
        for (int i = index; i < len && isNum(str.charAt(i)); i++) {
            count = count * 10 + (str.charAt(i) - '0');
            list.add(count);
            helper(str, i + count + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
