package medium;

public class MinimumNumberOfArrowsToBurstBalloons {
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=leetcode-75
    public int findMinArrowShots(int[][] points) {
    	if (points.length == 0) return 0;

        // Sort intervals by their end point
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // We need at least one arrow to start
        int currentEnd = points[0][1]; // End of the first interval

        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is beyond the end of the previous one, we need a new arrow
            if (points[i][0] > currentEnd) {
                arrows++; // Increase arrow count
                currentEnd = points[i][1]; // Update the position of the new arrow
            }
            // Else, the current balloon is already covered by the existing arrow
        }

        return arrows;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
		 */
	}

}
