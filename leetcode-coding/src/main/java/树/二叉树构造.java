package 树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/7/30 20:03
 */
public class 二叉树构造 {
    // 从前序和中序遍历构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        for (int i : preorder) {
            pre.add(i);
        }
        for (int i : inorder) {
            mid.add(i);
        }

        return help(pre, mid);
    }

    TreeNode help(List<Integer> pre, List<Integer> mid) {
        if (pre.size() == 0) {
            return null;
        }
        //前序遍历第一个为根节点
        int midIndex = mid.indexOf(pre.get(0));
        //创建根节点
        TreeNode root = new TreeNode(pre.get(0));
        //创建左子节点
        root.left = help(pre.subList(1, midIndex + 1), mid.subList(0, midIndex));
        //创建右子节点
        root.right = help(pre.subList(midIndex + 1, pre.size()), mid.subList(midIndex + 1, mid.size()));
        return root;
    }

    //从后序和中序遍历构造二叉树
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        List<Integer> last = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        for (int i : postorder) {
            last.add(i);
        }
        for (int i : inorder) {
            mid.add(i);
        }
        return help1(last, mid);
    }

    TreeNode help1(List<Integer> last, List<Integer> mid) {
        if (last.size() == 0) {
            return null;
        }
        //后序遍历最后一个为根节点
        int rootIndex = last.size() - 1;
        int midIndex = mid.indexOf(last.get(rootIndex));
        //创建根节点
        TreeNode root = new TreeNode(last.get(rootIndex));
        //创建左子节点
        root.left = help1(last.subList(0, midIndex), mid.subList(0, midIndex));
        //创建右子节点
        root.right = help1(last.subList(midIndex, rootIndex), mid.subList(midIndex + 1, mid.size()));
        return root;
    }
}
