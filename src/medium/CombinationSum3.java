package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
// https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int n, int start) {
        // Base case: if we've chosen k numbers and their sum is n
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current)); // add a copy of the current list to the result
            return;
        }
        
        // Base case: if the number of elements exceeds k or the sum becomes negative, stop exploring this path
        if (current.size() > k || n < 0) {
            return;
        }

        // Try adding numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            current.add(i); // Add the current number to the combination
            backtrack(result, current, k, n - i, i + 1); // Recursive call with updated sum and start
            current.remove(current.size() - 1); // Backtrack: remove the last element before the next iteration
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, 
there are no valid combination.
		 */
	}

}
