package easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
// https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // List to store the leaves of tree 1
        List<Integer> leaves1 = new ArrayList<>();
        // List to store the leaves of tree 2
        List<Integer> leaves2 = new ArrayList<>();
        
        // Collect leaves for both trees
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        
        // Compare the two leaf sequences
        return leaves1.equals(leaves2);
    }
    // Helper method to collect the leaf nodes of a binary tree
    public void collectLeaves(TreeNode node, List<Integer> leafSequence) {
        if (node == null) {
            return;
        }
        // If it's a leaf node, add its value to the list
        if (node.left == null && node.right == null) {
            leafSequence.add(node.val);
        }
        // Traverse the left subtree
        collectLeaves(node.left, leafSequence);
        // Traverse the right subtree
        collectLeaves(node.right, leafSequence);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
		 */
	}

}
