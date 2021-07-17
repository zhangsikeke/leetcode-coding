package 回溯系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 判断字符串是否满足规则 {
    public static void main(String[] args) {
        String str1 = "109something";
        // str1 = "5hello5world7kkkkkkk";
        // System.out.println(getLength(str1));
        System.out.println(getLengthExt(str1));
    }

    public static int getLength(String str) {
        System.out.println("str=>" + str);

        if (str == null || str.isEmpty()) {
            return -1;
        }
        char ch = str.charAt(0);
        if (ch == '0') {
            return -1;
        }
        int pos = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return -1;
        }
        System.out.println("pos=>" + pos);
        int[] res = new int[pos];
        for (int i = 0; i < pos; i++) {
            int num = Integer.valueOf(str.substring(0, i + 1));
            System.out.println("==>" + num);
            if (num > str.length() - i) {
                continue;
            }

            System.out.println("ok=>" + num + ":" + str.substring(i + 1, num + i + 1));
            res[i] = num;

            int tmp = getLength(str.substring(num + i + 1));
            if (tmp > 0) {
                res[i] += tmp;
            }

        }
        int total = 0;
        int len = 0;

        for (int i : res) {
            if (i > 0) {
                total++;
                len += i;
            }
        }
        System.out.println(Arrays.toString(res));
        return total == 1 ? len : -1;
    }

    public static int getLengthExt(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, str, 0);
        if (res.size() != 1) {
            return -1;
        } else {
            int sum = 0;
            for (Integer integer : res.get(0)) {
                sum += integer;
            }
            return sum;
        }
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, String str, int index) {

        if (index > str.length()) {
            return;
        }

        if (index == str.length()) {
            res.add(new ArrayList<>(list));
            System.out.println(res);
            return;
        }
        if (str.charAt(index) == '0' || !isNum(str.charAt(index))) {
            return;
        }
        int count = 0;
        for (int i = index; i < str.length() && isNum(str.charAt(i)); i++) {
            count = count * 10 + (str.charAt(i) - '0');
            list.add(count);
            helper(res, list, str, i + count + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
