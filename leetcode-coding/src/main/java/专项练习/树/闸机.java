package 专项练习.树;

import java.util.*;

/**
 * @author: keke
 * @date: 2021/6/7 23:01
 */
public class 闸机 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println("----------");
        System.out.println(Arrays.toString(test(new int[]{2, 2, 2, 2, 3, 3, 5, 5, 20, 20}, new int[]{0, 1, 1, 0, 0, 1, 1, 0, 0, 1})));
        // 2 0 1 5
    }

    public static int[] test(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lastTime = nums1[len1 - 1];
        int[] result = new int[len1];
        Queue<int[]> inQ = new LinkedList<>();
        Queue<int[]> outQ = new LinkedList<>();
        // 上个时刻的进站还是出站
        Map<Integer, Integer> map = new HashMap<>();
        // 记录上个时刻的人通过的时刻
        Map<Integer, Integer> map1 = new HashMap<>();
        int[] res = new int[len1];
        int pos = 0;
        for (int i = 0; i <= lastTime+10; i++) {
            // 当前时刻人分别进去进站队列和出站队列
            for (int i1 = pos; i1 < nums1.length; i1++) {
                if (nums1[i1] == i) {
                    if (nums2[i1] == 1) {
                        // 0：时刻 1：人
                        inQ.offer(new int[]{i, i1});
                    } else {
                        outQ.offer(new int[]{i, i1});
                    }
                }else{
                    pos = i1;
                    break;
                }
            }
            System.out.println("----" + i + "时刻，进" + getQString(inQ) + ",出" + getQString(outQ));
            boolean hasIn = false;
            // 开始计时间
            // 处理进站队列
            if (!inQ.isEmpty()) {
                if (!map.containsKey(i - 1) || map.get(i - 1) == 1 || outQ.isEmpty()) {
                    // 上个时刻没人进站
                    int[] p = inQ.poll();
                    map.put(i, nums2[p[1]]);
                    result[p[1]] = i;
                    System.out.println(i + "时刻，" + p[1] + "进站" + ",进站时刻" +  i + map + map1);
                    hasIn = true;
                }
            }
            // 处理出站队列
            if (!outQ.isEmpty() && !hasIn) {
                if (!map.containsKey(i - 1) || map.get(i - 1) == 0 || inQ.isEmpty()) {
                    // 上个时刻没人出站
                    int[] p = outQ.poll();
                    map.put(i, nums2[p[1]]);
                    result[p[1]] = i;
                    System.out.println(i + "时刻，" + p[1] + "出站" + ",出站时刻" +  i + map + map1);
                }
            }
        }
        return result;
    }

    private static String getQString(Queue<int[]> q) {
        String s = "";
        for (int[] o : q) {
            s += o[1] + ",";
        }
        return s;
    }
}
