package apr09042024;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    static { // this block makes solution faster
        for (int i = 0; i < 500; i++) {
            productExceptSelfBest(new int[]{0, 0});
        }
    }
    public static int[] productExceptSelfBest(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, left = 1; i < n; ++i) {
            ans[i] = left;
            left *= nums[i];
        }
        for (int i = n - 1, right = 1; i >= 0; --i) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
    public int[] productExceptSelf2(int[] nums) {
        int prod = 1;
        int zeroCount = 0;
        for (int i : nums) {
            if (i == 0) zeroCount++;
        }

        for (int i : nums) {
            if (zeroCount == 1 && i == 0) {

            }else {
                prod *= i;
            }
            
        }
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0)
                ans[i] = prod/nums[i];
            else if (zeroCount == 1) {
                if(nums[i] == 0) {
                    ans[i] = prod;
                } else {
                    ans[i] = 0;
                }
            }else {
                ans[i] = 0;
            }
        }
        return ans;
    }
	public int[] productExceptSelf(int[] nums) { // 3ms
	       // https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
	       int[] pref = new int[nums.length];
	       int[] suff = new int[nums.length];
	       int[] result = new int[nums.length];
	       pref[0] = nums[0];
	       suff[nums.length-1] = nums[nums.length-1];
	       for(int i=1; i<nums.length; i++){
	           pref[i] = pref[i-1]* nums[i];
	           //suff[i] = suff[nums.length-i-1]*nums[i];
	       }
	       for(int i=nums.length-2; i>=0; i--){
	           //pref[i] = pref[i-1]* nums[i];
	           suff[i] = suff[i+1]*nums[i];
	       }
	       result[0]=suff[1];
	       result[nums.length-1] = pref[nums.length-2];
	       for(int i=1; i<nums.length-1; i++){
	           result[i] = pref[i-1]*suff[i+1];
	       }
	       return result;
	       // 1 2 6 24
	       // 24 24 12 4
	   }
	public static void main(String[] args) {
		ProductOfArrayExceptSelf pa = new ProductOfArrayExceptSelf();
		int[] nums = {1,2,3,4};
		int[] x = pa.productExceptSelfBest(nums); // [24,12,8,6]
		Arrays.stream(x) 
        .asLongStream() 
        .forEach(e->System.out.print(e + " ")); // 
	}
}

