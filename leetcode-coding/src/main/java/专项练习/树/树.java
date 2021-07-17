package 专项练习.树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/5/23 20:33
 */
public class 树 {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode root7 = new TreeNode(7);
        TreeNode root3 = new TreeNode(3);

        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root44 = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root8 = new TreeNode(8);
        TreeNode root6 = new TreeNode(6);
        TreeNode root33 = new TreeNode(3);
        root.left = root7;
        root.right = root33;
        root7.left = root3;
        root7.right = root44;
        root3.left = root5;
        root5.left = root4;

        root44.left = root1;
        root1.left = root8;
        root44.right = root6;

        System.out.println(new 树().getSum(root));
    }

    public int getSum(TreeNode root) {
        dfs(root);
        System.out.println(list);
        return count(list);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(res));
        }
        dfs(root.left);
        dfs(root.right);
        res.remove(res.size() - 1);
    }

    private int count(List<List<Integer>> list) {
        int sum = 0;
        for (List<Integer> integers : list) {
            long tmpTotal = integers.stream().reduce(Integer::sum).orElse(0);
            int tmpSum = 0;
            for (Integer i : integers) {
                if (tmpSum == (tmpTotal - i) / 2) {
                    sum += i;
                    System.out.println(integers + ":" + i);
                    break;
                }
                tmpSum += i;
            }
        }
        return sum;
    }
}
