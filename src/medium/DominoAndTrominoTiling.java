package medium;

public class DominoAndTrominoTiling {
// https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int numTilings(int n) {
    	int MOD = 1_000_000_007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Initialize dp and partial arrays
        long[] dp = new long[n + 1];
        long[] partial = new long[n + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        partial[1] = 0;
        partial[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * partial[i - 1]) % MOD;
            partial[i] = (dp[i - 2] + partial[i - 1]) % MOD;
        }
        
        return (int) dp[n];
    }
    public int numTilingsBest(int n) {
        long[] dp = new long[n + 3]; dp[0] = 1; dp[1] = 2; dp[2] = 5;
         for (int i = 3; i < n; i ++) {
             dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
         }
         return (int)dp[n - 1];
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DominoAndTrominoTiling dt = new DominoAndTrominoTiling();
		System.out.println(dt.numTilings(3)); // 5
		System.out.println(dt.numTilings(1)); // 1
		System.out.println(dt.numTilings(4)); // 9 - 11
		/*
		 * Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1
		 */
	}

}
