package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
	
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
	public List<Integer> rightSideViewBest(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }

    public void rightView(TreeNode root, int level, List<Integer> ans){
        if(root == null){
            return;
        }

        if(level == ans.size()){    //level == ans.size(), this will ensure that we are adding the first element only of that level  from the right side in the list.
            ans.add(root.val);  // Ro
        }
        rightView(root.right, level+1, ans);  //R  
        rightView(root.left, level+1, ans);    //L
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {
            int l = temp.size();
            int val = 0;

            for (int i = 0; i < l; i++) {
                TreeNode node = temp.poll();
                val = node.val;

                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }

            ans.add(val);
        }

        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
		 */
	}

}
