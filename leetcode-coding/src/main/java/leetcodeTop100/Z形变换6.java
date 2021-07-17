package leetcodeTop100;

/**
 * @author: keke
 * @date: 2021/7/1 23:31
 */
public class Z形变换6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 3));
    }

    public static String convert(String s, int numRows) {
        if (s == null){
            return "";
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
                System.out.println(pos + ",x=" + x + ",y=" + y);
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
