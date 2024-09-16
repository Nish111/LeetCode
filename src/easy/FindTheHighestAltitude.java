package easy;

public class FindTheHighestAltitude {
// https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
	public int largestAltitude(int[] gain) {
		int temp=0;
		int max=0;
		for(int i=0; i<gain.length; i++) {
			temp += gain[i];
			max = Math.max(temp, max);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTheHighestAltitude fh = new FindTheHighestAltitude();
		int[] gain = {-5,1,5,0,-7};
		System.out.println(fh.largestAltitude(gain));
		int[] ggain = {-4,-3,-2,-1,4,3,2};
		System.out.println(fh.largestAltitude(ggain));
	}
/*
 * Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 
 */
}
