package medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
// https://leetcode.com/problems/rotting-oranges/?envType=study-plan-v2&envId=leetcode-75
	// Direction vectors for moving up, down, left, and right
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Add all initial rotten oranges to the queue, and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});  // Rotten orange
                } else if (grid[r][c] == 1) {
                    freshCount++;  // Fresh orange
                }
            }
        }
        
        // If there are no fresh oranges, return 0 as no time is needed
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        
        // Step 2: BFS to spread the rot to adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;  // Track if we rot any orange during this minute
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                // Try to infect adjacent cells (up, down, left, right)
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    // Check if the new cell is within bounds and has a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;  // Turn fresh orange to rotten
                        queue.offer(new int[] {newRow, newCol});  // Add to the queue
                        freshCount--;  // Decrease the count of fresh oranges
                        rotted = true;
                    }
                }
            }
            
            // Increment the time only if we rotted at least one fresh orange in this round
            if (rotted) {
                minutes++;
            }
        }
        
        // Step 3: Check if there are any fresh oranges left
        return freshCount == 0 ? minutes : -1;
    }
    public int orangesRottingBest(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    infect(grid, i, j);
                }
            }
        }

        int minInfectingTime = 2;
        for (int[] row : grid) {
            for (int rottenOrange : row) {
                if (rottenOrange == 1) return -1;
                if (rottenOrange > minInfectingTime) minInfectingTime = rottenOrange;
            }
        }

        return minInfectingTime - 2;
    }

    private void infect(int[][] grid, int i, int j) {
        int CONFIRMED_PATIENT = grid[i][j];

        if ((i > 0) && (grid[i-1][j] == 1 || grid[i-1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i-1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i-1, j);
        }

        if ((j > 0) && (grid[i][j-1] == 1 || grid[i][j-1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j-1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j-1);
        }

        if ((i + 1 < grid.length) && (grid[i+1][j] == 1 || grid[i+1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i+1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i+1, j);
        }

        if ((j + 1 < grid[0].length) && (grid[i][j+1] == 1 || grid[i][j+1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j+1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j+1);
        }
}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
		 */
	}

}
