package leetcode困难;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class 兄弟单词 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 3 abc bca cab abc 1
        while (scanner.hasNext()) {

            int total = 0;
            String first = "";
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int num = Integer.valueOf(strs[0]);
            String t = strs[num + 1];
            int tNum = Integer.valueOf(strs[num + 2]);
            List<String> broWord = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                if (isBrother(strs[i + 1], t)) {
                    total++;
                    broWord.add(strs[i + 1]);
                }
            }
            //按字典排序
            Collections.sort(broWord);
            System.out.println(total);
            //兄弟单词位置存在则输出
            if (tNum <= broWord.size()) {
                System.out.println(broWord.get(tNum - 1));
            }

        }
        scanner.close();

    }

    public static boolean isBrother(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else if (a.equals(b))
            return false;
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

}