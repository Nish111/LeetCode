package medium;

public class FindPeakElement {
// https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int findPeakElement(int[] nums) { // this is best
        if(nums.length==1) return 0;
    	int start=0, end=nums.length-1;
    	while(start<=end) {
    		int mid = start + (end-start)/2;
    		if(mid==0) {
    			if(nums[mid]> nums[mid+1]) return mid;
    			else start++;
    		}
    		else if(mid==nums.length-1) {
    			if(nums[mid]> nums[mid-1]) return mid;
    			else end--;
    		}
    		else {
    			if(nums[mid] > nums[mid+1] & nums[mid]> nums[mid-1]) return mid;
    			else if(nums[mid]<nums[mid+1]) start++;
    			else end--;
    		}
    	}
    	return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement fp = new FindPeakElement();
		int[] a = {1,2,3,1};
		System.out.println(fp.findPeakElement(a));
		int[] b = {1,2,1,3,5,6,4};
		System.out.println(fp.findPeakElement(b));
/*
 * Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
	}

}
