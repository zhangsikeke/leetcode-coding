package leetcode困难;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null,");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data) || data == null || "".equals(data)) {
            return null;
        }
        data = data.substring(1, data.length() - 2);
        int i = 0;
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[i]));
        i++;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(strs[i])) {
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(strs[i])) {
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
