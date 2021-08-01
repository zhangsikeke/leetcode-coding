package 深度搜索;

import com.sun.xml.internal.ws.api.pipe.SyncStartForAsyncFeature;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/7/24 18:34
 */
public class A_1466_重新规划路线 {
    public static void main(String[] args) {
        A_1466_重新规划路线 test = new A_1466_重新规划路线();
        //2103,new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}
        long start = System.currentTimeMillis();
        int res = test.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
        System.out.println(res);
    }

    public int minReorder(int n, int[][] connections) {
        // 存放某个城市所在的connections中的index
        List<List<Integer>> cityPosIndexList = new ArrayList<>();
        int len = connections.length;
        for (int i = 0; i < n; i++) {
            cityPosIndexList.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            cityPosIndexList.get(connections[i][0]).add(i);
            cityPosIndexList.get(connections[i][1]).add(i);
        }
        // 存放数据的位置是否已经访问过
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int res = 0;
        while (!queue.isEmpty()) {
            // 站出队列
            int currentCity = queue.poll();
            // 获取所有包含当前城市的的所有数据索引
            List<Integer> currentCityAllPosIndex = cityPosIndexList.get(currentCity);
            for (Integer cityIndex : currentCityAllPosIndex) {
                if (!visited[cityIndex]) {
                    visited[cityIndex] = true;
                    int fromCity = connections[cityIndex][0];
                    int toCity = connections[cityIndex][1];
                    // 如果是from->to,则缺少反方向的路径，需要修改的路径+1
                    res += (fromCity == currentCity) ? 1 : 0;
                    // 如果当前站点是from，将下一个站点加入队列，否则将from加入队列
                    queue.offer(fromCity == currentCity ? toCity : fromCity);
                }
            }
        }
        return res;
    }
}
