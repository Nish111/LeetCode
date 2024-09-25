package medium;

import java.util.Stack;

public class DailyTemperatures {
// https://leetcode.com/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75

	public int[] dailyTemperatures(int[] temperatures) {

		Stack<Integer> st = new Stack<>();
		int n = temperatures.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			// While the current temperature is higher than the temperature at the top of
			// the stack
			while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
				int index = st.pop(); // Get the index of the cooler day
				result[index] = i - index; // Calculate the number of days between the two
			}
			// Push the current index onto the stack
			st.push(i);
		}

		return result; // Return the answer array
	}

	public int[] dailyTemperaturesBest(int[] temperatures) {

		int n = temperatures.length;
		int maxTemp = 0;

		int res[] = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (maxTemp <= temperatures[i]) {
				maxTemp = temperatures[i];
				continue;
			}

			int days = 1;

			while (temperatures[i + days] <= temperatures[i]) {
				days += res[i + days];
			}

			res[i] = days;

		}

		return res;
	}

	/*
	 * Approach The idea is to traverse the array from left to right, and for each
	 * day, we maintain a stack of indices of the temperatures array, where the
	 * temperatures are in a decreasing order. As we traverse the array, for each
	 * temperature: If the current temperature is warmer than the temperature
	 * represented by the index at the top of the stack, we pop the stack and
	 * calculate the difference in days (i.e., the number of days it took to
	 * encounter a warmer day). We continue this until the stack is empty or the top
	 * of the stack has a temperature greater than or equal to the current day's
	 * temperature. We then push the current index onto the stack and move on. If
	 * there are indices left in the stack after traversing the entire array, it
	 * means there were no warmer days for those temperatures, so the result for
	 * those indices remains 0.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:
		 * 
		 * Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
		 * Example 2:
		 * 
		 * Input: temperatures = [30,40,50,60] Output: [1,1,1,0] Example 3:
		 * 
		 * Input: temperatures = [30,60,90] Output: [1,1,0]
		 * 
		 */
	}

}
