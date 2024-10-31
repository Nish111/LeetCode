package medium;

public class BestTimeToBuyAndSellStockWithTransactionFee {
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        // Initialize the two states
        int cash = 0;          // Max profit if we do not hold stock
        int hold = -prices[0]; // Max profit if we hold stock after the first day

        for (int i = 1; i < n; i++) {
            // Update cash and hold states
            cash = Math.max(cash, hold + prices[i] - fee); // Selling stock
            hold = Math.max(hold, cash - prices[i]);       // Buying stock
        }

        return cash; // Max profit at the end without holding stock
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStockWithTransactionFee bt = new BestTimeToBuyAndSellStockWithTransactionFee();
		System.out.println(bt.maxProfit(new int[] {1,3,2,8,4,9}, 2)); // 8
		System.out.println(bt.maxProfit(new int[] {1,3,7,5,10,3}, 3)); // 6

		/*
		 * Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
		 */
	}

}
