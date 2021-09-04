package 练级202109月份;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/8/27 23:41
 */
public class A4_173_二叉搜索树迭代器 {

    public class TreeNode {
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
    }

    private List<Integer> list;
    private int pos = 0;
    private int total = 0;

    public A4_173_二叉搜索树迭代器(TreeNode root) {
        list = new ArrayList<>();
        search(root);
        total = list.size();
    }

    private void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        list.add(root.val);
        search(root.right);
    }

    public int next() {
        if (pos < total) {
            int res = list.get(pos);
            pos++;
            return res;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext() {
        if (pos == total) {
            return false;
        }
        return true;
    }
}