package 树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/7/30 20:06
 */
public class A_257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        return list;
    }

    private void dfs(TreeNode root, String path, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        dfs(root.left, path + root.val + "->", list);
        dfs(root.right, path + root.val + "->", list);
    }

    // 另一种方式
    public List<String> binaryTreePaths1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs1(root, list, res);
        List<String> resList = new ArrayList<>();
        for (List<Integer> tmpList : list) {
            StringBuilder sb = new StringBuilder();
            for (int v : tmpList) {
                sb.append(v + "->");
            }
            if (sb.length() > 0) {
                String str = sb.toString();
                resList.add(str.substring(0, str.length() - 2));
            }
        }
        return resList;
    }

    private void dfs1(TreeNode root, List<List<Integer>> list, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(res));
        }
        dfs1(root.left, list, res);
        dfs1(root.right, list, res);
        res.remove(res.size() - 1);
    }
}
