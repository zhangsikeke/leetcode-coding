package 练级202109月份;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: keke
 * @date: 2021/9/8 22:20
 */
public class A8_502_IPO {
    /**
     * 排序+贪心
     *
     * @param k       最多投资k个项目
     * @param w       拥有资本
     * @param profits 第i个项目所获利润
     * @param capital 第i个项目所需资本
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        // 0:所需资本 1:可获利润
        int[][] programs = new int[len][2];
        for (int i = 0; i < len; ++i) {
            programs[i][0] = capital[i];
            programs[i][1] = profits[i];
        }
        // 项目按照所需资本最小排序
        Arrays.sort(programs, (a, b) -> a[0] - b[0]);

        // 大顶推存放利润
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int programPos = 0;
        int totalMoney = w;
        for (int i = 0; i < k; ++i) {
            // 资本够投资项目的情况下将所有项目都投资了，放入大顶推
            while (programPos < len && programs[programPos][0] <= totalMoney) {
                queue.add(programs[programPos][1]);
                programPos++;
            }
            // 堆顶就是最大利润
            if (!queue.isEmpty()) {
                totalMoney += queue.poll();
            } else {
                break;
            }
        }
        return totalMoney;
    }
}

