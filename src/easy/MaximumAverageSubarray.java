package easy;

public class MaximumAverageSubarray {
// https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
	
	   public double findMaxAverage(int[] nums, int k) {
	       int sum=0;

	       int start = 0, end = k, i=start;
	       while(i<end) {
	    	   sum+=nums[i];
	    	   i++;
	       }
	       double max = sum;
	       while(i<nums.length) {
	    	   sum-=nums[i-k];
	    	   sum+=nums[i];
	    	   max = Math.max(sum, max);
	    	   i++;
	       }
	       return (double)max/k;
	   }
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
		   MaximumAverageSubarray msa = new MaximumAverageSubarray();
		   int[] a = {1,12,-5,-6,50,3};
		   System.out.println(msa.findMaxAverage(a, 4));
		   System.out.println(msa.findMaxAverage(new int[]{5}, 1));
	/*
	 * Example 1:

	Input: nums = [1,12,-5,-6,50,3], k = 4
	Output: 12.75000
	Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
	Example 2:

	Input: nums = [5], k = 1
	Output: 5.00000
	 */
		}
}
