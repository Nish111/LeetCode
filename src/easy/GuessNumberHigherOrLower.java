package easy;

public class GuessNumberHigherOrLower {
// https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int guessNumber(int n) {
        int start=1, end=n;
        while(start<=end) {
        	int mid = start + (end-start)/2;
        	if(guess(mid)==-1) end = mid-1;
        	else if(guess(mid)== 1) start=mid+1;
        	else return mid;
        }
        return 0;
    }
	private int guess(int mid) {
	// TODO Auto-generated method stub
		// Predefined API
	return 0;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
		 */
	}

}
