package 递归系列;

import java.util.ArrayList;
import java.util.List;

public class 括号生成_22 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        dfs(list, new StringBuilder(), 3, 0, 0);
        System.out.println(list);
    }

    public static void dfs(List<String> list, StringBuilder sb, int n, int left, int right) {
        if (left > n || right > left)
            return;
        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }
        dfs(list, sb.append("("), n, left + 1, right);
        sb.deleteCharAt(sb.length()-1);
        dfs(list, sb.append(")"), n, left, right + 1);
        sb.deleteCharAt(sb.length()-1);
    }

}
