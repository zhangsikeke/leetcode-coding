package 深度搜索;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/8/1 15:35
 */
public class Graph extends AbstractGraph {

    public Graph(String[] vertexs, Edge[] edgeList, boolean directed) {
        super(vertexs, edgeList, directed);
        init(vertexs, edgeList, directed);
    }


    @Override
    public void init(String[] vertexs, Edge[] edgeList, boolean directed) {
        this.size = vertexs.length;
        this.vertexs = vertexs;
        this.directed = directed;
        this.edges = new int[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r == c)
                    edges[r][c] = 0;// 对角线位置为0
                else
                    edges[r][c] = -1;
            }
        }

        // 初始化矩阵
        for (Edge edge : edgeList) {
            int begin = indexOf(edge.getStart());
            int end = indexOf(edge.getEnd());
            int instance = edge.getDistance();
            edges[begin][end] = instance;
            if (!this.directed)
                edges[end][begin] = instance;
        }
    }

    @Override
    public int indexOf(String name) {
        if (name == null)
            return -1;
        for (int i = 0; i < size; i++) {
            if (name.equals(vertexs[i]))
                return i;
        }
        return -1;
    }

    @Override
    public void show() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(edges[r][c] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public void dfsSearch(String name, int[] visited, String tmpPath, List<String> paths) {
        int index = indexOf(name);
        tmpPath = name;
        // 访问当前节点
        System.out.print(name + " ");
        visited[index] = 1;
        for (int i = 0; i < visited.length; i++) {
            if (edges[index][i] > 0 && visited[i] == 0) {
                paths.add(tmpPath += SPLIT + vertexs[i]);
                dfsSearch(vertexs[i], visited, tmpPath, paths);

            }
            if (edges[index][i] > 0 && !tmpPath.endsWith(vertexs[i])) {
                paths.add(name + SPLIT + vertexs[i]);
            }
        }

    }

    @Override
    public void bfsSearch(String name) {
        int[] visit = new int[size];
        LinkedList<Integer> quene = new LinkedList<>();
        int startIndex = indexOf(name);

        // 将根节点入队尾
        quene.add(startIndex);
        visit[startIndex] = 1;

        while (!quene.isEmpty()) {

            // 出队
            int nodeIndex = quene.removeFirst();

            // 访问出队节点
            System.out.print(vertexs[nodeIndex] + " ");

            // 邻节点入队
            for (int i = 0; i < size; i++) {
                if (edges[nodeIndex][i] > 0 && visit[i] == 0) {
                    visit[i] = 1;
                    quene.add(i);
                }
            }
        }
    }

    @Override
    public String getDistance(String path) {
        int romote = 0;
        String[] paths = path.split(SPLIT);
        for (int i = 0; i < paths.length - 1; i++) {
            int start = indexOf(paths[i]);
            int end = indexOf(paths[i + 1]);
            if (start < 0 || end < 0 || edges[start][end] < 0) {
                return "NO SUCH ROUTE";
            }
            romote += edges[start][end];
        }
        return romote + "";
    }

    @Override
    public Map<String, String> getPaths(String fromName, String toName) {
        boolean[] visited = new boolean[size];
        Stack<Integer> stack = new Stack<Integer>();
        Map<String, String> pathMap = new HashMap<>();
        getPaths(fromName, toName, visited, stack, pathMap);
        return pathMap;
    }

    @Override
    public void getPaths(String fromName, String toName, boolean[] visited, Stack<Integer> stack,
                         Map<String, String> pathMap) {
        int startIndex = indexOf(fromName);
        int endIndex = indexOf(toName);
        // 假如当前点已经访问过，就返回
        if (visited[startIndex] == true)
            return;
        // 当前点入栈
        stack.push(startIndex);
        // 当前点已经访问
        visited[startIndex] = true;
        // 如果当前点是目标点，输出
        if (startIndex == endIndex) {
            getMessage(stack, pathMap);
            visited[startIndex] = false;
            stack.pop();
            return;
        }
        // 对相连的每个顶点进行搜索
        for (int i = 0; i < size; i++) {
            if (edges[startIndex][i] > 0 && startIndex != i) {
                getPaths(vertexs[i], toName, visited, stack, pathMap);
            }

        }
        // 搜索完毕后弹出，清除标志
        visited[startIndex] = false;
        stack.pop();
    }

    private void getMessage(Stack<Integer> stack, Map<String, String> pathMap) {
        Iterator<Integer> iterator = stack.iterator();
        String messageString = "";
        while (iterator.hasNext()) {
            messageString += vertexs[iterator.next()] + SPLIT;
        }
        if (stack.size() == 0)
            return;
        String path = messageString.substring(0, messageString.length() - 2);
        String distance = getDistance(path);
        pathMap.put(path, distance);
    }

    // 递归DFS 获取所有闭合路径
    public void findCycle(int v, int[] visited, List<Integer> trace) {
        int j;
        // 添加闭环信息
        if ((j = trace.indexOf(v)) != -1) {
            StringBuffer sb = new StringBuffer();
            String startNode = vertexs[trace.get(j)];
            while (j < trace.size()) {
                sb.append(vertexs[trace.get(j)] + "-");
                j++;
            }
            System.out.println("cycle:" + sb.toString() + startNode);
            return;
        }
        trace.add(v);
        // visited[i] = 1;
        for (int i = 0; i < size; i++) {
            if (edges[v][i] > 0) {
                findCycle(i, visited, trace);
            }
        }
        trace.remove(trace.size() - 1);

    }

    @Override
    public String getMinDistance(String fromName, String toName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getMaxDistance(String fromName, String toName) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        // AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge("A", "B", 5));
        edges.add(new Edge("B", "C", 4));
        edges.add(new Edge("C", "D", 8));
        edges.add(new Edge("D", "C", 8));
        edges.add(new Edge("D", "E", 6));
        edges.add(new Edge("A", "D", 5));
        edges.add(new Edge("C", "E", 2));
        edges.add(new Edge("E", "B", 3));
        edges.add(new Edge("A", "E", 7));

        Graph g = new Graph(new String[]{"A", "B", "C", "D", "E"}, edges.toArray(new Edge[edges.size()]), true);
        g.show();

        System.out.println(g.getDistance("A->B->C"));
        System.out.println(g.getDistance("A->D"));
        System.out.println(g.getDistance("A->D->C"));
        System.out.println(g.getDistance("A->E->B->C->D"));
        System.out.println(g.getDistance("A->E->D"));

        System.out.println("深度搜索===================");
        int[] visted = new int[5];
        List<String> rList = new ArrayList<>();
        g.dfsSearch("A", visted, "", rList);
        System.out.println();
        Collections.sort(rList);
        Map<String, List<String>> map = new HashMap<>();
        for (String s : rList) {
            String b = s.substring(0, 1);
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            String[] strings = s.split(Graph.SPLIT);
            for (int i = 1; i < strings.length; i++) {
                map.get(b).add(strings[i]);
            }
        }
        for (String k : map.keySet()) {
            System.out.println(k + ":" + map.get(k));
        }
        System.out.println("深度搜索===================");

        System.out.println("广度搜索===================");
        g.bfsSearch("A");
        System.out.println();
        System.out.println("广度搜索===================");

        System.out.println("获取两点之间所有路径===================");
        Map<String, String> pathMap = g.getPaths("A", "E");
        System.out.println("距离\t路径");
        pathMap.forEach((k, v) -> {
            System.out.println(v + "\t" + k);
        });
        System.out.println("所有某个点闭合路径===================");
        int[] visited = new int[5];
        List<Integer> trace = new ArrayList<>();
        g.findCycle(0, visited, trace);
    }
}
