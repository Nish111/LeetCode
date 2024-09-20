package medium;

public class LongestArrayOfOnesAfterDeletingOneElement {
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
    public int longestSubarray(int[] nums) { // working
        
    	int left=0, right=0, totalLength=0, result=0, countOnes=0;
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]==0) {
    			left=0; right=0;
    			for(int j=i-1; j>=0; j--) {
    				if(nums[j]==1) left++;
    				else break;
    			}
    			for(int k=i+1; k<nums.length; k++) {
    				if(nums[k]==1) right++;
    				else break;
    			}
    			totalLength = left+right;
    			result = Math.max(totalLength, result);
    		}
    		else countOnes++;
    	}
    	return countOnes==nums.length?countOnes-1:result;
    }
    public int longestSubarrayBest(int[] nums) {
        boolean zero_found = false;
        int prev_count = 0 ; int count = 0; int res = 0; int total = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0) {
                zero_found = true;
                total = prev_count + count;
                res = total > res ? total : res;
                prev_count = count;
                count = 0;
            }
            else {
                count+=1 ;
            }
        }
        total = prev_count + count;
        res = total > res? total : res;
        if(zero_found)
            return res;
        else
            return n-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestArrayOfOnesAfterDeletingOneElement le = new LongestArrayOfOnesAfterDeletingOneElement();
		int[] a = {1,1,0,1};
		System.out.println(le.longestSubarray(a));
		int[] b = {0,1,1,1,0,1,1,0,1};
		System.out.println(le.longestSubarray(b));
		int[] c = {1,1,1};
		System.out.println(le.longestSubarray(c));
		/*
		 * Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
		 */
	}

}
