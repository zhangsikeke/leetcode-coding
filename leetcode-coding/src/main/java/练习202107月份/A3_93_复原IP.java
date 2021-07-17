package 练习202107月份;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+剪枝
 *
 * @author: keke
 * @date: 2021/7/3 12:21
 */
public class A3_93_复原IP {
    private List<String> list = new ArrayList<>();
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);
        return list;
    }

    public void dfs(String s, int pos) {
        if (res.size() > 4) {
            return;
        }
        // 满足4个但pos没走到最后一个说明还剩余的有字符，剪枝
        if (res.size() >= 4 && pos != s.length()) {
            return;
        }
        if (res.size() == 4) {
            list.add(String.join(".", res));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String str = s.substring(pos, i + 1);
            // 根据调价剪枝
            if (str.length() > 1 && str.startsWith("0") || str.length() > 3 || Integer.valueOf(str) > 255) {
                continue;
            }
            res.add(str);
            dfs(s, i + 1);
            res.remove(res.size() - 1);
        }
    }
}
