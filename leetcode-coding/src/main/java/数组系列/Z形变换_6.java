package 数组系列;

public class Z形变换_6 {

    public static void main(String[] args) {
        // LEETCODEISHIRING
        System.out.println("--------------------");
        System.out.println(convert("LEETCODEISHIRING", 4));

    }

    /**
     * 在矩阵中填充Z字形然后再筛选
     * 
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        char[] cs = s.toCharArray();
        if (cs.length == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        char[][] cc = new char[numRows][cs.length];
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[0].length; j++) {
                cc[i][j] = ' ';
            }
        }
        int x = 0;
        int y = 0;
        boolean down = true;
        cc[0][0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            if (down) {
                x++;
            }
            if (down && x >= numRows) {
                down = false;
                x -= 2;
                y++;
            } else if (!down) {
                x--;
                y++;
            }

            if (!down && x < 0) {
                down = true;
                x += 2;
                y--;
            }
            cc[x][y] = cs[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[0].length; j++) {
                if (cc[i][j] != ' ') {
                    sb.append(cc[i][j]);
                }
            }
        }
        show(cc);
        return sb.toString();
    }

    public static void show(char[][] cc) {
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[0].length; j++) {
                System.out.print(cc[i][j] + " ");
            }
            System.out.println();
        }
    }
}
