package medium;


public class CountGoodNodesInBinaryTree {
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
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
    public int goodNodes(TreeNode root) {
    	// We start with the root, where the max value is the root's value itself
        return countGoodNodes(root, root.val);
    }
    // Helper function to count the good nodes
    public int countGoodNodes(TreeNode node, int maxSoFar) {
        // Base case: if the node is null, return 0 (no good nodes)
        if (node == null) {
            return 0;
        }
        
        // A good node is one where its value is greater than or equal to maxSoFar
        int goodNodeCount = 0;
        if (node.val >= maxSoFar) {
            goodNodeCount = 1;
        }
        
        // Update the maximum value seen so far for the children
        maxSoFar = Math.max(maxSoFar, node.val);
        
        // Recursively count good nodes in the left and right subtrees
        goodNodeCount += countGoodNodes(node.left, maxSoFar);
        goodNodeCount += countGoodNodes(node.right, maxSoFar);
        
        // Return the total count of good nodes for this subtree
        return goodNodeCount;
    }
    public int goodNodesBest(TreeNode root) {
        int max = root.val;
        return countOfGoodNodeBest(root, max);
    }

    private static int countOfGoodNodeBest(TreeNode root, int max) {
        int cnt = max > root.val ? 0: 1;
        if(root.val > max) {
            max = root.val;
        }

        if(root.left!=null) cnt += countOfGoodNodeBest(root.left, max);
        if(root.right!=null) cnt += countOfGoodNodeBest(root.right, max);

        return cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.
		 */
	}

}
