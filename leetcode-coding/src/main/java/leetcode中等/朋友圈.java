package leetcode中等;

import java.util.LinkedList;
import java.util.Queue;

// leetcode-Friend Circles(朋友圈）
// 1、题目描述
//
// 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
//
// 示例1：
//
// 输入:
//
// [[1,1,0],
//
//   [1,1,0],
//
//    [0,0,1]]
//
// 输出: 2
//
// 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。 第2个学生自己在一个朋友圈。所以返回2。
//
// 示例2：
//
// 输入:
//
// [[1,1,0],
//
//  [1,1,1],
//
//  [0,1,1]]
//
// 输出: 1
//
// 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
//
// 注意：
//
// N 在[1,200]的范围内。
// 对于所有学生，有Mii = 1。
// 如果有Mij = 1，则有Mji = 1。

/**
 * 深度遍历获广度遍历算法，对于学生A，遍历他的所有朋友，再遍历他的朋友的朋友，这样就得到包含学生A的最大朋友圈。之后重复上面的这个操作就好了，即可得到不同的朋友圈个数。
 * 
 * @author keke
 * @date 2020/05/11
 */

public class 朋友圈 {

    static StringBuffer sb = new StringBuffer();

    public static int findFriendCirclesNum(int[][] nums) {
        int len = nums.length;
        boolean[] visted = new boolean[len];
        int circleNum = 0;
        for (int i = 0; i < len; i++) {

            if (!visted[i]) {
                sb.append(i);
                bfsSearch(nums, i, visted);
                // dfsSearch(nums, i, visted);
                circleNum++;
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return circleNum;
    }

    /**
     * 
     * @param nums
     * @param k
     *            第几个人
     * @param visted
     *            保存是否便利过
     */
    public static void dfsSearch(int[][] nums, int index, boolean[] visted) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!visted[i] && nums[i][index] == 1) {
                visted[i] = true;
                if (sb.indexOf(i + "") < 0) {
                    sb.append("->" + i);
                }
                dfsSearch(nums, i, visted);
            }
        }
    }

    public static void bfsSearch(int[][] nums, int index, boolean[] visted) {
        int len = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (!visted[i] && nums[i][index] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int i = 0; i < len; i++) {
                if (!visted[i] && nums[i][k] == 1) {
                    visted[i] = true;
                    queue.offer(i);
                    if (sb.indexOf(i + "") < 0) {
                        sb.append("->" + i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums1 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] nums2 = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println("共" + findFriendCirclesNum(nums1) + "朋友圈");
        System.out.println("-------");
        System.out.println("共" + findFriendCirclesNum(nums2) + "朋友圈");
    }
}
