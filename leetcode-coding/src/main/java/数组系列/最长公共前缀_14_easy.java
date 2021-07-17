package 数组系列;

/**
 * 14.https://leetcode-cn.com/problems/longest-common-prefix/
 * @author keke
 * @date 2020/11/21
 */
public class 最长公共前缀_14_easy {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        int length = firstStr.length();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || firstStr.charAt(i) != strs[j].charAt(i)) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}
