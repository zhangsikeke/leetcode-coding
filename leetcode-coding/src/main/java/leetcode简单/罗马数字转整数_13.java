package leetcode简单;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数_13 {
    public static final Map<String, Integer> MAP = new HashMap<String, Integer>();
    static {
        MAP.put("I", 1);
        MAP.put("V", 5);
        MAP.put("X", 10);
        MAP.put("L", 50);
        MAP.put("C", 100);
        MAP.put("D", 500);
        MAP.put("M", 1000);

        MAP.put("IV", 4);
        MAP.put("IX", 9);
        MAP.put("XL", 40);
        MAP.put("XC", 90);
        MAP.put("CD", 400);
        MAP.put("CM", 900);
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int sum = 0;
        int len = s.length();
        int pos = 0;
        while (pos < len) {
            if (pos + 2 <= len && MAP.containsKey(s.subSequence(pos, pos + 2))) {
                sum += MAP.get(s.subSequence(pos, pos + 2));
                pos += 2;
            } else {
                sum += MAP.get(s.subSequence(pos, pos + 1));
                pos += 1;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
