package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
	
	// Directions for moving in the maze (up, down, left, right)
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {entrance[0], entrance[1], 0}); // Start from entrance with 0 steps
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            
            // Explore all four directions
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                // Check if the new position is within bounds and is an empty cell
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.') {
                    // If it's at the border and not the entrance, it's an exit
                    if (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) {
                        return steps + 1;
                    }
                    // Mark as visited and add to the queue
                    maze[newRow][newCol] = '+';
                    queue.add(new int[] {newRow, newCol, steps + 1});
                }
            }
        }
        // If no exit is found
        return -1;
    }

    public int nearestExitBest(char[][] maze, int[] entrance) {
        // find the shortest path from entrance to nearest exit
        int length = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] start = {entrance[0], entrance[1], 0};
        q.add(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] curr;
        int x = 0;
        int y = 0;
        // length must be included with each node
        while(!q.isEmpty()) {
            // dequeue current node
            curr = q.remove();
            // check if it's a border cell
            if(curr[0] == 0 || curr[0] == maze.length - 1 || curr[1] == 0 || curr[1] == maze[0].length - 1) {
                if(curr[0] != entrance[0] || curr[1] != entrance[1]){
                    return curr[2];
                }
                
            }
            // System.out.println("curr: " + curr[0] + ", " + curr[1]);
            // explore neighbors
            for(int[] dir : dirs) {
                x = curr[0] + dir[0];
                y = curr[1] + dir[1];
                
                if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '+') {
                    continue;
                }
                if(maze[x][y] == '.' && !visited[x][y]) {
                    // System.out.println("Adding x: " + x + " y: " + y);
                    int[] next = {x, y, curr[2] + 1};
                    q.add(next);
                    visited[x][y] = true; //mark visited as soon as it's added to the queue!
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
		 */
	}

}
