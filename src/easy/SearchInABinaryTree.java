package easy;

public class SearchInABinaryTree {
// https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        // Loop to search the tree
        while (temp != null) {
            if (temp.val == val) {
                return temp;  // If the node is found, return the node
            } else if (val < temp.val) {
                temp = temp.left;  // Search in the left subtree
            } else {
                temp = temp.right; // Search in the right subtree
            }
        }
        
        // If the value is not found, return null
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []
 */
	}

}
