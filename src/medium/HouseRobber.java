package medium;

public class HouseRobber {
// https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Base case: if there's only one house
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Initialize the two variables to track the maximum amount robbed up to two houses
        int prev2 = nums[0];  // Robbing the first house
        int prev1 = Math.max(nums[0], nums[1]);  // Rob the maximum of first or second house
        
        // Traverse the array and calculate the maximum for each house
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        // The answer is the maximum amount robbed up to the last house
        return prev1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber hr =  new HouseRobber();
		System.out.println(hr.rob(new int[] {1,2,3,1}));
		System.out.println(hr.rob(new int[] {2,7,9,3,1}));
				
		/*
		 * Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
		 */
	}

}
