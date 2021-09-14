package 周赛.第258周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/9/12 12:08
 */
public class A2_可互换矩形的组数 {
    public long interchangeableRectangles(int[][] rectangles) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            double t = rectangles[i][0] * 1.0 / rectangles[i][1];
            list.add(t);
        }
        list.sort((a, b) -> {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });
        if (list.isEmpty()) {
            return 0;
        }
        long tmpCount = 0;
        long count = 0;
        double preT = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            double t2 = list.get(i);
            if (preT == t2) {
                tmpCount++;
            } else {
                if (tmpCount > 0) {
                    count += getCount(tmpCount);
                }
                preT = t2;
                tmpCount = 0;
            }
        }
        if (tmpCount > 0) {
            count += getCount(tmpCount);
        }
        return count;
    }

    public long getCount(long n) {
        return (1 + n) * n / 2;
    }

}
