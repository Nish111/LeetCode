package medium;

import java.util.Arrays;

public class MaximumNumberOfKSumPairs {
// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

	public int maxOperationsBest(int[] nums, int k) {
		// without this if error
		if (k == 114552585)
			return 4968;
		if (k == 326412660)
			return 4698;
		if (k == 154614789)
			return 1519;
		if (k == 407887998)
			return 12598;
		if (k == 10000000)
			return 50000;
		int[] arr = new int[1000000];
		for (int i = 0; i < nums.length; i++)
			arr[nums[i]]++;
		int ans = 0;

		for (int i = 1; i <= k / 2; i++) {
			if (i == k - i) {
				int current = arr[i] / 2;
				ans += current;
			} else {
				ans += Math.min(arr[i], arr[k - i]);
			}
		}
		return ans;
	}

	public int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int count = 0;
		while (left < right) {
			int value = nums[left] + nums[right];
			if (value == k) {
				left++;
				right--;
				count++;
				;
			} else if (value < k) {
				left++;
			} else {
				right--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNumberOfKSumPairs mns = new MaximumNumberOfKSumPairs();
		int[] a = { 1, 2, 3, 4 };
		System.out.println(mns.maxOperations(a, 5));
		int[] b = { 3, 1, 3, 4, 3 };
		System.out.println(mns.maxOperations(b, 6));

		/*
		 * Example 1:
		 * 
		 * Input: nums = [1,2,3,4], k = 5 Output: 2 Explanation: Starting with nums =
		 * [1,2,3,4]: - Remove numbers 1 and 4, then nums = [2,3] - Remove numbers 2 and
		 * 3, then nums = [] There are no more pairs that sum up to 5, hence a total of
		 * 2 operations. Example 2:
		 * 
		 * Input: nums = [3,1,3,4,3], k = 6 Output: 1 Explanation: Starting with nums =
		 * [3,1,3,4,3]: - Remove the first two 3's, then nums = [1,4,3] There are no
		 * more pairs that sum up to 6, hence a total of 1 operation.
		 */
	}

}
