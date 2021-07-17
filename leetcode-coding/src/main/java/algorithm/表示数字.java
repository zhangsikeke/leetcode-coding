package algorithm;

public class 表示数字 {
    public static String MarkNum(String pInStr) {
        char[] cs = pInStr.toCharArray();
        int len = cs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            if (i == 0 && cs[i] >= '0' && cs[i] <= '9') {
                sb.append("*");
            }
            if (i > 0 && cs[i] >= '0' && cs[i] <= '9'
                && (cs[i - 1] >= 'a' && cs[i - 1] <= 'z' || cs[i - 1] >= 'A' && cs[i - 1] <= 'Z')) {
                sb.append("*");
            }
            sb.append(cs[i]);
            if (cs[i] >= '0' && cs[i] <= '9'
                && (cs[i + 1] >= 'a' && cs[i + 1] <= 'z' || cs[i + 1] >= 'A' && cs[i + 1] <= 'Z')) {
                sb.append("*");
            }
        }
        if (isNum(cs[len - 1])) {
            if (isAlpha(cs[len - 2])) {
                sb.append("*");
                sb.append(cs[len - 1]);
                sb.append("*");
            } else {
                sb.append(cs[len - 1]);
                sb.append("*");
            }
        } else {
            sb.append(cs[len - 1]);
        }
        String res = sb.toString();
        return res;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
