package medium;


public class LongestZigzagPathInBinaryTree {
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
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
	
	int maxLength = 0;
    public int longestZigZag(TreeNode root) {
    	
        // Start from the root, moving left and right
        dfs(root, true, 0);  // true indicates starting with left direction
        dfs(root, false, 0); // false indicates starting with right direction
        return maxLength;
    }
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }

        // Update the maximum length found
        maxLength = Math.max(maxLength, length);

        // If the last move was to the left, the next move should be to the right
        if (isLeft) {
            dfs(node.right, false, length + 1); // Move right and increment length
            dfs(node.left, true, 1);             // Restart path from the left child
        } else {
            dfs(node.left, true, length + 1);    // Move left and increment length
            dfs(node.right, false, 1);           // Restart path from the right child
        }
    }
    public int longestZigZagBetter(TreeNode root) {
        findLongest(root.left, 'r', 'l', 0);
        findLongest(root.right, 'l', 'r', 0);
        return maxLength;
    }
    public void findLongest(TreeNode root, char pre, char afterPre, int curr) {
        if (root == null) return;
        int rightNow = 1;
        if (pre != afterPre) {
            rightNow = curr + 1;
            maxLength = Math.max(maxLength, rightNow);
        }
        if (root.left != null) {
            findLongest(root.left, afterPre, 'l', rightNow);
        }

        if (root.right != null) {
            findLongest(root.right, afterPre, 'r', rightNow);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
		 */
	}

}
