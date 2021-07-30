package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: keke
 * @date: 2021/7/30 20:04
 */
public class 二叉树的序列化和反序列化 {
    //通过分层遍历实现二叉树的序列化和反序列化，没有的节点用null表示，以此来表示其完整信息
    //序列化
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
        String res = sb.toString();
        return res;
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] str = data.substring(1, data.length() - 2).split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(str[i]));
        i++;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(str[i])) {
                node.left = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(str[i])) {
                node.right = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
