package leetcode中等;

public class 字符串解码_394 {
    private int reachIndex;

    public String decodeString(String s) {
        return dfs(s, 0);
    }

    public String dfs(String s, int start) {
        // 记录字母
        StringBuilder sb = new StringBuilder();
        // 记录数字
        StringBuilder sbNum = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                // 记录数据
                sbNum.append(c);
            } else if (c >= 'a' && c <= 'z') {
                // 记录字母
                sb.append(c);
            } else if (c == '[') {
                // 如果是[,递归查找[后面的字符
                String tmpStr = dfs(s, i + 1);
                // 记录一次数据
                int len = Integer.parseInt(sbNum.toString());
                sbNum.delete(0, sbNum.length());
                for (int j = 0; j < len; j++) {
                    sb.append(tmpStr);
                }
                i = reachIndex;
            } else if (c == ']') {
                // 如果是]说明记录完成，返回数据
                reachIndex = i; // 记录当前计算，字符到达的位置
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
