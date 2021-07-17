package 专项练习.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * 
 * @author keke
 * @date   2021/04/23
 */
public class 无重复字符的最长子串_3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int tmpLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int j = map.getOrDefault(ch, -1);
            tmpLen = tmpLen < i - j ? tmpLen + 1 : i - j;
            max = Math.max(max, tmpLen);
        }
        return max;
    }

    public static int lengthOfLongestSubstringExt(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        char[] data = s.toCharArray();
        while (right < len) {
            char ch = data[right];
            int index = getCharIndexFromWind(data, left, right - 1, ch);
            if (index > -1) {
                left = index + 1;
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static int getCharIndexFromWind(char[] data, int left, int right, char ch) {
        for (int i = left; i <= right; i++) {
            if (data[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringExt("abcdef"));
    }
}
