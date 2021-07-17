package 专项练习.字符串;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * 
 * @author keke
 * @date   2021/04/23
 */
public class 单词的压缩编码_820 {
    public static int minimumLengthEncoding(String[] words) {
        // 先按字符串长度进行排序
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

        // 然后在进行匹配的计算
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.indexOf(word + "#") == -1) {
                sb.append(word + "#");
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[] {"time", "me", "bell"}) == 10);
    }
}
