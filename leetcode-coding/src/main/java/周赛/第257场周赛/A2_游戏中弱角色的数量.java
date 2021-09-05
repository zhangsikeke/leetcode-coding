package 周赛.第257场周赛;

import java.util.Arrays;

/**
 * @author: keke
 * @date: 2021/8/27 23:41
 */
public class A2_游戏中弱角色的数量 {
    public static void main(String[] args) {
        A2_游戏中弱角色的数量 test = new A2_游戏中弱角色的数量();
        System.out.println("res：" + test.numberOfWeakCharacters(new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}));
    }


    public int numberOfWeakCharacters(int[][] properties) {
        // 攻击力从大到小排序,攻击力相同防御力从小到大排序,先降低一个维度的比较
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        int len = properties.length;
        int count = 0;
        // 记录已遍历过角色的最大防御力
        int preMaxDefense = properties[0][1];
        for (int i = 0; i < len; i++) {
            // 因为按照攻击降序排序了，前面攻击力度肯定比后面大，之需要比较防御力
            // 当前防御力小于前面的防御力,说明满足弱角色条件
            if (properties[i][1] < preMaxDefense) {
                count++;
            } else {
                // 更新已遍历过的角色最大防御力
                preMaxDefense = properties[i][1];
            }
        }
        return count;
    }
}