package medium;

public class LongestCommonSubsequence {
// https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int longestCommonSubsequence(String text1, String text2) {
		int N = text1.length();
		int M = text2.length();
		int dp[][] = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				dp[i][j]=-1;
		int ans = lcs(N-1, M-1, dp, text1, text2);
		return ans;
    }
	public int lcs(int i, int j, int[][] dp, String A, String B) {
		if(i==-1 || j==-1) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		if(A.charAt(i)==B.charAt(j)) {
			dp[i][j] = lcs(i-1, j-1, dp, A, B)+1;
		} else {
			dp[i][j] = Math.max(lcs(i-1, j, dp, A, B), lcs(i, j-1, dp, A, B));
		}
		return dp[i][j];
	}
	public int longestCommonSubsequenceBest(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[2][n + 1];
        for (int i = 1, prv = 0, cur = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) dp[cur][j] = chars1[i - 1] == chars2[j - 1] ? dp[prv][j - 1] + 1 : Math.max(dp[cur][j - 1], dp[prv][j]);
            prv ^= 1;
            cur ^= 1;
        }
        return dp[m & 1][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.longestCommonSubsequenceBest("abcde", "ace")); // 3
		System.out.println(lcs.longestCommonSubsequence("abc", "abc")); // 3
		System.out.println(lcs.longestCommonSubsequence("abc", "def")); // 0
		/*
		 * Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
		 */
	}

}
