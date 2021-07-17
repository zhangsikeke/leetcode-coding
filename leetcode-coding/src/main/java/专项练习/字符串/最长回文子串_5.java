package 专项练习.字符串;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/<br>
 * 中心扩散/动态规划
 * 
 * @author keke
 * @date   2021/04/23
 */
public class 最长回文子串_5 {
    public static String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int max = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            int ll = i - 1;
            int rr = i + 1;
            int tmpLen = 1;
            // 往左扩散
            while (ll >= 0 && chs[ll] == chs[i]) {
                tmpLen++;
                ll--;
            }
            // 往右扩散
            while (rr < len && chs[rr] == chs[i]) {
                tmpLen++;
                rr++;
            }
            // 左右扩散
            while (ll >= 0 && rr < len && chs[ll] == chs[rr]) {
                tmpLen += 2;;
                ll--;
                rr++;
            }
            if (tmpLen > max) {
                max = tmpLen;
                left = ll;
            }
        }
        return s.substring(left + 1, left + max + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

}
