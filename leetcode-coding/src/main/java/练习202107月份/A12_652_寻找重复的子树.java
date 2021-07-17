package 练习202107月份;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前缀+map
 *
 * @author: keke
 * @date: 2021/7/10 22:36
 */
public class A12_652_寻找重复的子树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node21 = new TreeNode(2);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node21;
        node3.right = node41;
        node21.left = node42;
        new A12_652_寻找重复的子树().findDuplicateSubtrees(root);
    }

    private List<TreeNode> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        System.out.println(list);
        return list;
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "@";
        }
        String str = node.val + "|" + dfs(node.left) + "|" + dfs(node.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            list.add(node);
        }
        System.out.println(str);
        return str;
    }
}
