package 树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/7/30 20:06
 */
public class A_1382_将二叉搜索树变平衡 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return gen(list, 0, list.size() - 1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private TreeNode gen(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = gen(list, start, mid - 1);
        root.right = gen(list, mid + 1, end);
        return root;
    }
}
