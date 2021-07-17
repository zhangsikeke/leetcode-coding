package algorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 从单向链表中删除指定值的节点 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        从单向链表中删除指定值的节点 m = new 从单向链表中删除指定值的节点();

        // 5 2 3 2 4 3 5 2 1 4 3
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int sLen = Integer.valueOf(strs[0]);
            int root = Integer.valueOf(strs[1]);
            int target = Integer.valueOf(strs[strs.length - 1]);

            Queue<String> queue = new LinkedList<String>();

            int index = 2;
            for (int i = 0; i < sLen - 1; i++) {
                queue.offer(strs[index] + " " + strs[index + 1]);
                index += 2;
            }

            Node rootNode = m.createNode(sLen, root, queue);
            // m.showNode(rootNode);
            m.showNode(m.deleteNode(rootNode, target));

        }

        // queue.offer("1 2");
        // queue.offer("3 2");
        // queue.offer("5 1");
        // queue.offer("4 5");
        // queue.offer("7 2");
        // Node rootNode = m.createNode(5, 2, 2, queue);
        // m.showNode(rootNode);
        // m.showNode(m.deleteNode(rootNode, 2));

    }

    static class Node {
        public int value;
        public Node next;

        public Node(int v, Node next) {
            super();
            this.value = v;
            this.next = next;
        }

    }

    Node createNode(int nodeLen, int root, Queue<String> queue) {
        Node rootNode = new Node(root, null);
        while (queue.size() > 0) {
            String[] strs = queue.poll().split(" ");
            int cur = Integer.valueOf(strs[1]);
            int next = Integer.valueOf(strs[0]);
            Node tmpNode = rootNode;
            while (tmpNode != null) {
                if (cur == tmpNode.value) {
                    Node newNode = new Node(next, null);
                    if (tmpNode.next != null) {
                        newNode.next = tmpNode.next;
                    }
                    tmpNode.next = newNode;
                    break;
                }

                tmpNode = tmpNode.next;
            }

        }
        return rootNode;
    }

    Node deleteNode(Node root, int target) {
        if (root.value == target) {
            return root.next;
        }
        Node tmpNode = root;
        Node preNode = root;
        while (tmpNode != null) {
            if (tmpNode.value == target) {
                if (tmpNode.next == null) {
                    preNode.next = null;
                    break;
                } else {
                    tmpNode.value = tmpNode.next.value;
                    tmpNode.next = tmpNode.next.next;
                }
            }
            preNode = tmpNode;
            tmpNode = tmpNode.next;
        }
        return root;
    }

    void showNode(Node root) {
        Node tmpNode = root;
        while (tmpNode != null) {
            System.out.print(tmpNode.value + " ");
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }

}
