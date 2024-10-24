package easy;

public class MinCostClimbingStairs {
// https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan-v2&envId=leetcode-75
    public int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
        
        // Base case: if there's only one or two steps
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);
        
        // dp[i] will store the minimum cost to reach the ith step
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        // Return the minimum cost to reach the top of the staircase
        return Math.min(dp[n-1], dp[n-2]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostClimbingStairs mc = new MinCostClimbingStairs();
		System.out.println(mc.minCostClimbingStairs(new int []{10, 15, 20}));
		int[] a = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(mc.minCostClimbingStairs(a));
		/*
		 * Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
		 */
	}

}
