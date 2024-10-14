package medium;

import java.util.List;

public class NumberOfProvinces {
// https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];  // Track which cities have been visited
        int provinceCount = 0;

        // Iterate through each city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // If the city is not visited, start DFS
                dfs(isConnected, i, visited);
                provinceCount++;  // Increment province count after a DFS completes
            }
        }

        return provinceCount;
    }

    private void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;  // Mark the current city as visited

        // Visit all directly connected cities
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {  // If city j is connected and not visited
                dfs(isConnected, j, visited);  // Recursively visit city j
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
		 */
	}

}
