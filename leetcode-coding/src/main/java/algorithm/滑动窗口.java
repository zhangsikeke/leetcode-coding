package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 滑动窗口 {

    /**
     * 和为target的连续正数序列
     * 
     * @param  target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (i < target) {
            if (sum < target) {
                // 右边界向右
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右
                sum -= i;
                i++;
            } else {
                // 满足条件记录结果
                int[] tmp = new int[j - i];
                for (int k = i; k < j; k++) {
                    tmp[k - i] = k;
                }
                list.add(tmp);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
