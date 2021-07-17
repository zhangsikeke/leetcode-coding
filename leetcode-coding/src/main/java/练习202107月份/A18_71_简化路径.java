package 练习202107月份;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A18_71_简化路径 {
    public static void main(String[] args) {

        String res = new A18_71_简化路径().simplifyPath("/../");
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {

            if ("..".equals(strs[i]) && !stack.isEmpty()) {
                stack.pop();
            } else if (!"".equals(strs[i]) && !".".equals(strs[i])) {
                stack.push(strs[i]);
                stack.push("/");
                System.out.println(stack);
            }
        }

        return "/" + String.join("", stack);
    }
}
