package leetcode中等;

import java.math.BigDecimal;

/**
 * 可以使用自动机DFA做，暂时还没学自动机是个啥，下面是纯ifelse版本
 * 
 * @author keke
 * @date 2020/11/27
 */
public class 字符串转换整数_8 {
    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        char[] cs = str.toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        if (cs[0] != '-' && cs[0] != '+' && !Character.isDigit(cs[0])) {
            return 0;
        }
        boolean flg = false;
        if (cs[0] == '-') {
            flg = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            char chr = cs[i];
            if (i == 0 && (chr == '-' || chr == '+')) {
                continue;
            }
            if (chr >= '0' && chr <= '9') {
                sb.append(chr);
            } else {
                break;
            }
        }
        String newStr = sb.toString();
        if (newStr.isEmpty()) {
            return 0;
        }
        BigDecimal bigDecimal = new BigDecimal(flg ? "-" + newStr : newStr);
        if (new BigDecimal(Integer.MIN_VALUE).compareTo(bigDecimal) >= 0) {
            return Integer.MIN_VALUE;
        }
        if (bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) >= 0) {
            return Integer.MAX_VALUE;
        }
        int value = Integer.parseInt(newStr);
        return value = flg ? -1 * value : value;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
        StringBuilder sbBuilder = new StringBuilder("-123");
        System.out.println(sbBuilder.reverse().toString());
    }
}
