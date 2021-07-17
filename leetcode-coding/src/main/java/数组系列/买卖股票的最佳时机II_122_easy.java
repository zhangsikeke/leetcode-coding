package 数组系列;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author keke
 * @date 2020/11/21
 */
public class 买卖股票的最佳时机II_122_easy {
    /**
     * 贪心算法
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int total = 0;
        int buyPrice = -1;
        for (int i = 0; i < len - 1; i++) {
            // 买入
            if (buyPrice < 0 && prices[i + 1] > prices[i]) {
                buyPrice = prices[i];
                total -= buyPrice;
            }
            // 卖出
            if (buyPrice > -1 && prices[i + 1] < prices[i]) {
                total += prices[i];
                buyPrice = -1;
            }
        }
        // 买入状态下卖出最后一股
        if (buyPrice > -1)
            total += prices[len - 1];
        return total;
    }
}
