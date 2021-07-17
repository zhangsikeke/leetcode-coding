package exam;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 贪吃蛇 {

    public static boolean debug = true;

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // while (scanner.hasNext()) {}
        // scanner.close();

        test();
    }
    public static void test() {

        String[] ways = "L G G G G".split(" ");

        String[] strs = "5 4".split(" ");

        String[][] data = {
            {"F", "F", "E", "E"}, 
            {"F", "F", "E", "E"}, 
            {"E", "F", "F", "F"},
            {"F", "E", "E", "H"},
            {"E", "F", "E", "E"}};

        // 行
        int n = data.length; //Integer.parseInt(strs[0]);
        // 列
        int m = data[0].length; //Integer.parseInt(strs[1]);
        
        debugln("原始数据");
        showOriginSnake(data);

        // 记录蛇
        List<Node> list = new ArrayList<>();
        createSnake(data, list);
        
        debugln("========获取蛇后的数据");
        showSnake(data, list);
        
        // F食物 E 空格 H 头
        // G往前走一格,UDLR表示转向
        // 当前方向
        String curWay = "";
        for (String way : ways) {

            // 记录方向
            if (isWay(way)) {
                curWay = way;
                continue;
            }
            // 2.运动
            if (way.equals("G")) {

                if (curWay.equals("L")) {
                    boolean success = goLeft(list, data);
                    if (!success) {
                        break;
                    }
                } else if (curWay.equals("R")) {
                    boolean success = goRight(list, data);
                    if (!success) {
                        break;
                    }
                } else if (curWay.equals("U")) {
                    boolean success = goUp(list, data);
                    if (!success) {
                        break;
                    }

                } else if (curWay.equals("D")) {
                    boolean success = goDown(list, data);
                    if (!success) {
                        break;
                    }
                }

            }

        }
        debugln("=========最终显示");
        showSnake(data, list);

    }
    public static boolean killSelf(List<Node> list, int x, int y) {
        for (Node node : list) {
            if (node.x == x && node.y == y) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWay(String way) {
        if (way.equals("L") || way.equals("R") || way.equals("U") || way.equals("D")) {
            return true;
        }
        return false;
    }

    /**
     * 造蛇
     * 
     * @param data
     * @return
     */
    public static void createSnake(String[][] data, List<Node> list) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j].equals("H")) {
                    list.add(new Node(i, j));
                    Set<String> set = new HashSet<>();
                    set.add(i + "-" + j);
                    dfs(data, i, j, list, set);
                    return;
                }
            }
        }
    }

    /**
     * 深度遍历获取身体,* 代表蛇身体
     * 
     * @param data
     * @param x
     * @param y
     * @param list
     */
    public static void dfs(String[][] data, int x, int y, List<Node> list, Set<String> visited) {
        if (x + 1 < data.length && data[x + 1][y].equals("*") && !visited.contains((x + 1) + "-" + y)) {
            list.add(new Node(x + 1, y));
            visited.add((x + 1) + "-" + y);
            dfs(data, x + 1, y, list, visited);
        } else if (x - 1 >= 0 && data[x - 1][y].equals("*") && !visited.contains((x - 1) + "-" + y)) {
            list.add(new Node(x - 1, y));
            visited.add((x - 1) + "-" + y);
            dfs(data, x - 1, y, list, visited);
        } else if (y - 1 >= 0 && data[x][y - 1].equals("*") && !visited.contains(x + "-" + (y - 1))) {
            list.add(new Node(x, y - 1));
            visited.add(x + "-" + (y - 1));
            dfs(data, x, y - 1, list, visited);
        } else if (y + 1 < data[0].length && data[x][y + 1].equals("*") && !visited.contains(x + "-" + (y + 1))) {
            list.add(new Node(x, y + 1));
            visited.add(x + "-" + (y + 1));
            dfs(data, x, y + 1, list, visited);
        }
    }

    // 向上移动
    public static boolean goDown(List<Node> list, String[][] data) {
        // 蛇头
        Node head = list.get(0);
        // 下移动
        if (head.x == data.length - 1) {
            return false;
        }
        // 撞到自己了
        if (killSelf(list, head.x + 1, head.y)) {
            return false;
        }
        // 吃食物变大
        if (data[head.x + 1][head.y].equals("F")) {
            // 添加头
            list.add(0, new Node(head.x + 1, head.y));
        }
        // 遇到空格往前移动
        if (data[head.x + 1][head.y].equals("E")) {
            Node lastNode = list.get(list.size() - 1);
            // 最后一个身体变空
            data[lastNode.x][lastNode.y] = "E";
            for (int i = list.size() - 1; i > 0; i--) {
                list.get(i).x = list.get(i - 1).x;
                list.get(i).y = list.get(i - 1).y;
            }
            head.x = head.x + 1;
        }
        return true;
    }

    // 向上移动
    public static boolean goUp(List<Node> list, String[][] data) {
        // 蛇头
        Node head = list.get(0);
        // 上移动
        if (head.x == 0) {
            debugln("到下边界了");
            return false;
        }
        // 撞到自己了
        if (killSelf(list, head.x - 1, head.y)) {
            debugln("向下撞到自己了");
            return false;
        }
        // 吃食物变大
        if (data[head.x - 1][head.y].equals("F")) {
            debugln("向下遇到食物");
            // 添加头
            list.add(0, new Node(head.x - 1, head.y));
        }
        // 遇到空格往前移动
        if (data[head.x - 1][head.y].equals("E")) {
            Node lastNode = list.get(list.size() - 1);
            // 最后一个身体变空
            data[lastNode.x][lastNode.y] = "E";
            for (int i = list.size() - 1; i > 0; i--) {
                list.get(i).x = list.get(i - 1).x;
                list.get(i).y = list.get(i - 1).y;
            }
            head.x = head.x - 1;
        }
        return true;
    }

    // 向左移动
    public static boolean goLeft(List<Node> list, String[][] data) {
        // 蛇头
        Node head = list.get(0);
        // 移动
        if (head.y == 0) {
            debugln("向左到边界了");
            return false;
        }
        // 撞到自己了
        if (killSelf(list, head.x, head.y - 1)) {
            debugln("向左撞到自己了");
            return false;
        }
        // 吃食物变大
        if (data[head.x][head.y - 1].equals("F")) {
            debugln("向左遇到食物");
            // 添加头
            list.add(0, new Node(head.x, head.y - 1));
        }
        // 遇到空格往前移动
        if (data[head.x][head.y - 1].equals("E")) {
            Node lastNode = list.get(list.size() - 1);
            // 最后一个身体变空
            data[lastNode.x][lastNode.y] = "E";
            for (int i = list.size() - 1; i > 0; i--) {
                list.get(i).x = list.get(i - 1).x;
                list.get(i).y = list.get(i - 1).y;
            }
            head.y = head.y - 1;
        }
        return true;
    }

    // 向左移动
    public static boolean goRight(List<Node> list, String[][] data) {

        // 蛇头
        Node head = list.get(0);

        // 移动
        if (head.y == data[0].length - 1) {
            debugln("向右到边界");
            return false;
        }
        // 撞到自己了
        if (killSelf(list, head.x, head.y + 1)) {
            return false;
        }
        // 吃食物变大
        if (data[head.x][head.y + 1].equals("F")) {
            debugln("向右遇到食物");
            // 添加头
            list.add(0, new Node(head.x, head.y + 1));
        }

        // 遇到空格往前移动
        if (data[head.x][head.y + 1].equals("E")) {

            Node lastNode = list.get(list.size() - 1);
            // 最后一个身体变空
            data[lastNode.x][lastNode.y] = "E";
            for (int i = list.size() - 1; i > 0; i--) {
                list.get(i).x = list.get(i - 1).x;
                list.get(i).y = list.get(i - 1).y;
            }
            head.y = head.y + 1;
        }
        return true;
    }

   

    public static void showSnake(String[][] data, List<Node> list) {

        debugln("蛇长度：" + list.size());
        debug("蛇位置，第一个为蛇头位置：");
        for (Node node : list) {
            debug(node.x + "," + node.y + " ");
        }
        debugln("");
        Set<String> set = new HashSet<>();
        for (Node node : list) {
            set.add(node.x + "-" + node.y);
        }
        int hx = list.get(0).x;
        int hy = list.get(0).y;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (hx == i && hy == j) {
                    debug("H ");
                } else if (set.contains(i + "-" + j)) {
                    debug("* ");
                } else {
                   debug(data[i][j] + " ");
                }
            }
            debugln("");
        }
    }

    public static void showOriginSnake(String[][] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                debug(data[i][j] + " ");
            }
            debugln("");
        }
    }

    public static void debug(Object o) {
        if (debug) {
            System.out.print(o);
        }
    }

    public static void debugln(Object o) {
        if (debug) {
            System.out.println(o);
        }
    }

}
