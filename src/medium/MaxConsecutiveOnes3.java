package medium;

public class MaxConsecutiveOnes3 {
// https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
	public int longestOnes(int[] nums, int k) {
		int n = nums.length, noOfOnes = 0;
		;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1)
				noOfOnes++;
		}
		System.out.println(noOfOnes);
		if (noOfOnes + k >= n)
			return n;
		int start = 0, end = noOfOnes + k, temp = 0, result = 0;
		while (start < end) {
			if (nums[start] == 1)
				temp++;
			start++;
		}
		result = Math.max(temp + k, result);
		while (start < n - end + 1) {
			if (nums[start] == 1) {
				temp++;
			}
			if (nums[start - end + 1] == 1)
				temp--;
			start++;
			result = Math.max(temp + k, result);
		}
		return result;
	}

	public int longestOnesBest(int[] nums, int k) { //
		int left = 0, right = 0, maxLen = 0, zerosCount = 0;

		while (right < nums.length) {
			// If the right pointer encounters a 0, increase the count of zeros
			if (nums[right] == 0) {
				zerosCount++;
			}

			// If there are more than k zeros, shrink the window from the left
			while (zerosCount > k) {
				if (nums[left] == 0) {
					zerosCount--;
				}
				left++;
			}

			// Calculate the length of the current valid window
			maxLen = Math.max(maxLen, right - left + 1);

			// Move the right pointer to explore the array
			right++;
		}

		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxConsecutiveOnes3 mc = new MaxConsecutiveOnes3();
		int[] a = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		System.out.println(mc.longestOnesBest(a, 2)); // 6
		int[] b = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		System.out.println(mc.longestOnesBest(b, 3)); // 10
		/*
		 * Example 1:
		 * 
		 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation:
		 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
		 * subarray is underlined. Example 2:
		 * 
		 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
		 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
		 * flipped from 0 to 1. The longest subarray is underlined.
		 */
	}

}
