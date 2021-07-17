package 练习202107月份;

/**
 * 模拟
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A4_6_Z形变换 {
    public String convert(String s, int numRows) {
        if (s == null) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int col = s.length();
        char[][] chars = new char[numRows][col];
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = 0; i1 < chars[i].length; i1++) {
                chars[i][i1] = ' ';
            }
        }
        int way = 0;
        int pos = 0;
        int total = s.length();
        int x = 0;
        int y = 0;
        while (pos < total) {

            if (way == 0) {
                // 下
                if (x >= numRows) {
                    x -= 2;
                    y++;
                    way = 1;
                    continue;
                }
                chars[x][y] = s.charAt(pos);
                pos++;
                x++;
            }
            if (way == 1) {
                // 上
                if (x < 0) {
                    x = 1;
                    way = 0;
                    y--;
                    continue;
                }
                chars[x][y] = s.charAt(pos);
                pos++;
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = 0; i1 < chars[i].length; i1++) {
                if (chars[i][i1] != ' ') {
                    sb.append(chars[i][i1]);
                }
            }
        }
        return sb.toString();
    }
}
