package medium;

public class UniquePaths {
// https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp array using the recurrence relation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // The bottom-right corner contains the answer
        return dp[m - 1][n - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
		 */
	}

}
