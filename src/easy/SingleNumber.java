package easy;

public class SingleNumber {
// https://leetcode.com/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int singleNumber(int[] nums) {
    	if(nums.length==1) return nums[0];
        int result=nums[0];
        for(int i=1; i<nums.length; i++) {
        	result = result ^ nums[i];
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		int[] a = {2,2,1};
		System.out.println(sn.singleNumber(a));
		int[] b = {4,1,2,1,2};
		System.out.println(sn.singleNumber(b));
		/*
		 * Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
		 */
	}

}
