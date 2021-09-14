package 练级202109月份;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/8/27 23:41
 */
public class A12_678_有效的括号字符串 {
    public static void main(String[] args) {
        A12_678_有效的括号字符串 test = new A12_678_有效的括号字符串();
        System.out.println(test.checkValidString("(*))"));

    }

    public boolean checkValidString(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackStar = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stackLeft.push(i);
            } else if (chs[i] == '*') {
                stackStar.push(i);
            } else {
                // 右括号
                if (!stackLeft.isEmpty()) {
                    // 弹出一个左括号
                    stackLeft.pop();
                } else if (!stackStar.isEmpty()) {
                    // 弹出一个*当左括号
                    stackStar.pop();
                } else {
                    return false;
                }
            }
        }
        // 剩下的左while括号和*，*只能当右括号用了
        while (!stackLeft.isEmpty() && !stackStar.isEmpty()) {
            // 如果*在(右边，不匹配
            if (stackLeft.pop() > stackStar.pop()) {
                return false;
            }
        }
        // 左括号匹配完说明满足条件
        return stackLeft.isEmpty();
    }
}