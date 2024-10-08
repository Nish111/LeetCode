package medium;

import java.util.HashMap;

public class PathSum3 {
// https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
    public int pathSum(TreeNode root, int targetSum) {
    	 // HashMap to store (prefixSum, count of such prefixSum)
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        // Initially, prefix sum of 0 occurs once (no nodes included)
        prefixSumMap.put(0L, 1);
        // Start DFS to count paths
        return dfs(root, 0L, targetSum, prefixSumMap);
    }
    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Update the current path sum
        currentSum += node.val;

        // Calculate the number of valid paths ending at this node
        int numPathsToCurrent = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum map with the current sum
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Count paths in the left and right subtrees
        int totalPaths = numPathsToCurrent +
                dfs(node.left, currentSum, targetSum, prefixSumMap) +
                dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: remove the current node's value from the prefixSumMap
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return totalPaths;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
