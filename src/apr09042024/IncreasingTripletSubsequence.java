package apr09042024;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) { // TLE
	       // https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
		 for(int i=0; i<nums.length-2; i++){
	           int temp = nums[i];
	           for(int j=i+1; j<nums.length-1; j++) {
	        	   int val = nums[j];
	        	   if(val>temp) {
	        		   for(int k=j+1; k<nums.length; k++) {
	        			   int value = nums[k];
	        			   if(value>val) return true;
	        		   }
	        	   }
	           }
	       }
	       return false;
	   }
	public boolean increasingTriplet2(int[] nums) { // Best
	       // https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
	      
	       if (nums == null || nums.length < 3) {
	            return false;
	        }
	        int a = Integer.MAX_VALUE;
	        int b = Integer.MAX_VALUE;
	        
	        for (int num : nums) {
	            if (num <= a) {
	                a = num;
	            } else if (num <= b) {
	                b = num;
	            } else {
	                return true;
	            }
	        }
	        
	        return false;
	   }
	public static void main(String[] args) {
		IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
		int[] nums = {1,2,3,4,5};
		System.out.println(its.increasingTriplet2(nums));// true
		System.out.println(its.increasingTriplet2(new int[] {5,4,3,2,1}));// false
		System.out.println(its.increasingTriplet2(new int[] {2,1,5,0,4,6}));// true
		System.out.println(its.increasingTriplet2(new int[] {20,100,10,12,5,13}));
		// false - expected is true
		System.out.println(its.increasingTriplet2(new int[] {1,5,0,4,1,3}));
		// false - expected is true
	}
}

