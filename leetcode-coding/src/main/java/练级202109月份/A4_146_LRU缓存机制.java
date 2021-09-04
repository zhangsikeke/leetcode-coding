package 练级202109月份;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: keke
 * @date: 2021/9/4 20:51
 */
public class A4_146_LRU缓存机制 {

    private int total;
    private int currentTime;
    private Map<Integer, Node> map;
    private List<Node> list;

    static class Node {
        public int key;
        public int value;
        public long time;

        public Node(int key, int value, long time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }
    }

    public A4_146_LRU缓存机制(int capacity) {
        total = capacity;
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            map.get(key).time = ++currentTime;
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == total) {
            list.sort((a, b) -> {
                if (a.time < b.time) {
                    return -1;
                } else if (a.time > b.time) {
                    return 1;
                } else {
                    return 0;
                }
            });
            Node node = list.remove(0);
            map.remove(node.key);
        }
        if (map.containsKey(key)) {
            map.get(key).value = value;
            map.get(key).time = ++currentTime;
        } else {
            Node newNode = new Node(key, value, ++currentTime);
            map.put(key, newNode);
            list.add(newNode);
        }
    }
}
