package easy;

public class NthTribonacciNumber {
// https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
	// Method to calculate the nth Tribonacci number
    public int tribonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        // Initialize the first three Tribonacci numbers
        int t0 = 0, t1 = 1, t2 = 1;

        // Iterate to calculate the nth Tribonacci number
        for (int i = 3; i <= n; i++) {
            int tn = t0 + t1 + t2;
            t0 = t1; // Update t0 to the next value in the sequence
            t1 = t2; // Update t1 to the next value in the sequence
            t2 = tn; // Update t2 to the current Tribonacci number
        }

        // Return the nth Tribonacci number
        return t2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthTribonacciNumber nt = new NthTribonacciNumber();
		System.out.println(nt.tribonacci(4)); // 4
		System.out.println(nt.tribonacci(25)); // 1389537
		/*
		 * Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
		 */
	}

}
