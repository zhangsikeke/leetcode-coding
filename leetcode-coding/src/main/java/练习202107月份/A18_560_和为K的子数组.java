package 练习202107月份;

import java.util.*;

/**
 *
 * 前缀和+hash
 * 7道题：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf/</a>
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A18_560_和为K的子数组 {
    public static void main(String[] args) {
        new A18_560_和为K的子数组().subarraySum1(new int[]{0, 1, 1}, 2);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public int subarraySum1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);//获取次数
            }
            //更新
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
