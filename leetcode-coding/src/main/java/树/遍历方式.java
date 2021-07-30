package 树;

import common.TreeNode;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/7/30 19:58
 */
public class 遍历方式 {
    // 前序遍历
    void frontTraverse(TreeNode node) {
        if (node == null) return;
        //访问节点
        frontTraverse(node.left);
        frontTraverse(node.right);
    }

    //中序遍历
    void midTraverse(TreeNode node) {
        if (node == null) return;
        midTraverse(node.left);
        //访问节点
        midTraverse(node.right);
    }

    //  后续遍历
    void endTraverse(TreeNode node) {
        if (node == null) return;
        endTraverse(node.left);
        endTraverse(node.right);
        //访问节点
    }

    // 层级遍历
    void levelTraverse(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            //从上到下遍历每一层节点
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmpNode = queue.poll();
                //访问节点
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
        }
    }

    // ====================迭代遍历=============================
    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //访问节点
            list.add(node.val);
            //右节点入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            //左节点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            //将左子节点全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //访问节点
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    //后续遍历是 左右根，实际就是将 根右左进行翻转
    public List<Integer> endOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //访问节点
            list.add(node.val);
            //左节点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            //右节点入栈
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        //按照以上的遍历的结果是：根右左，翻转后得到左右根
        Collections.reverse(list);
        return list;
    }
}
