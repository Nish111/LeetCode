package medium;

import medium.LongestZigzagPathInBinaryTree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
	
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root==null || root==p || root==q)
    		return root;
		/*
		 * // check if root is lca if(dfs(root, p) && dfs(root, q)) return root; // if
		 * so check again if its left or right is // continue same until u find it is
		 * not lca else return root; // return previous if not lca
		 */    	
        // Recursively search in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null subtree where p or q was found
        return left != null ? left : right;
        
    }
    private boolean dfs(TreeNode node, TreeNode p) {
    	if(node==p) return true;
    	else if(node.left==p || node.right==p) return true;
    	else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
		 */
	}

}
