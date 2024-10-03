package easy;

public class MaximumDepthOfBinaryTree {
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
	
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
	int count=0;
    public int maxDepth(TreeNode root) {
    	TreeNode temp = root;
    	if(temp==null) return 0;
    	if(temp.left==null && temp.right==null) return count+1;
    	else {
    		return Math.max(maxDepth(temp.left)+1, maxDepth(temp.right)+1);
    	}
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepthOfBinaryTree md = new MaximumDepthOfBinaryTree();
		
		/*
		 * Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
		 */
	}

}
