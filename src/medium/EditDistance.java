package medium;

public class EditDistance {
// https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75
    public int minDistance(String word1, String word2) {
    	 int m = word1.length();
         int n = word2.length();

         // DP array
         int[][] dp = new int[m + 1][n + 1];

         // Initialize DP table
         for (int i = 0; i <= m; i++) {
             dp[i][0] = i; // If word2 is empty, delete all characters from word1
         }
         for (int j = 0; j <= n; j++) {
             dp[0][j] = j; // If word1 is empty, insert all characters into word1 to match word2
         }

         // Fill the DP table
         for (int i = 1; i <= m; i++) {
             for (int j = 1; j <= n; j++) {
                 if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                     dp[i][j] = dp[i - 1][j - 1]; // Characters match, no extra cost
                 } else {
                     dp[i][j] = Math.min(
                         dp[i - 1][j] + 1,    // Delete
                         Math.min(dp[i][j - 1] + 1,   // Insert
                                  dp[i - 1][j - 1] + 1) // Replace
                     );
                 }
             }
         }

         // Result is the minimum operations to convert word1 to word2
         return dp[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("horse", "ros")); // 3
		System.out.println(ed.minDistance("intention", "execution")); // 5
				
/*
 * Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
	}

}
