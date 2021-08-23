package 练习202108月份;

import java.util.*;

/**
 * 图克隆
 *
 * @author: keke
 * @date: 2021/8/5 23:32
 */
public class A23_133_克隆图 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node neighbor : tmp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                map.get(tmp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}