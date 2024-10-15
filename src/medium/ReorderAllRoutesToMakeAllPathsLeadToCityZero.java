package medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderAllRoutesToMakeAllPathsLeadToCityZero {
// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int minReorder(int n, int[][] connections) {
        // Step 1: Create a bidirectional graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Populate the graph, marking original directions
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1});  // Directed away from city 0
            graph.get(to).add(new int[]{from, 0});  // Directed towards city 0
        }

        // Step 3: DFS to count the reorientations
        return dfs(graph, new boolean[n], 0);
    }
    // DFS helper method
    private int dfs(List<List<int[]>> graph, boolean[] visited, int city) {
        visited[city] = true;
        int changeCount = 0;

        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int needsReorientation = neighbor[1];

            if (!visited[nextCity]) {
                // Count this edge if it's directed away from city 0
                changeCount += needsReorientation;
                // Recursively explore further cities
                changeCount += dfs(graph, visited, nextCity);
            }
        }

        return changeCount;
    }
    int count;
    boolean[] rechable;
    int[][] connections;
    public int minReorderBest(int n, int[][] connections) {
        this.connections = connections;
        rechable = new boolean[n];
        rechable[0] = true;

        for(int i=0; i<n; i++) {
            compute(i);
        }

        return count;
    }

    private void compute(int index) {
        if(index >= connections.length)
            return;
        int u = connections[index][0];
        int v = connections[index][1];

        if(rechable[v]) {
            rechable[u] = true;
            return;
        }
        if(rechable[u]) {
            count++;
            rechable[v] = true;
        } else {
            compute(index+1); 
            
            if(rechable[v]) {
                rechable[u] = true;
                return;
            }
            if(rechable[u]) {
                count++;
                rechable[v] = true;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
		 */
	}

}
