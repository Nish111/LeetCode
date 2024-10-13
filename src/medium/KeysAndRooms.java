package medium;

import java.util.List;

public class KeysAndRooms {
// https://leetcode.com/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
	
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	 boolean[] visited = new boolean[rooms.size()];
         // Start the DFS from room 0
         dfs(rooms, 0, visited);
         
         // After DFS, check if all rooms are visited
         for (boolean roomVisited : visited) {
             if (!roomVisited) {
                 return false;
             }
         }
         
         return true;
    }
    // Helper method to perform DFS
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        // Mark the current room as visited
        visited[room] = true;
        
        // Visit all rooms whose keys are found in the current room
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
		 */
	}

}
