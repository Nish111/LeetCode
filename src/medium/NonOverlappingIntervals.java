package medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
// https://leetcode.com/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75
    public int eraseOverlapIntervals(int[][] intervals) {
    	 if (intervals.length == 0) return 0;

         // Sort intervals by their end time
         Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

         int nonOverlappingCount = 1; // Count of non-overlapping intervals
         int lastEnd = intervals[0][1]; // End of the last added interval
         int removals = 0; // Number of intervals to remove

         for (int i = 1; i < intervals.length; i++) {
             // Check if the current interval overlaps with the last non-overlapping interval
             if (intervals[i][0] >= lastEnd) {
                 // No overlap, update the end time to the current interval's end
                 lastEnd = intervals[i][1];
                 nonOverlappingCount++;
             } else {
                 // Overlap, we need to remove this interval
                 removals++;
             }
         }

         return removals;
    }
public int eraseOverlapIntervalsBest(int[][] intervals) {
        
        int result =0;
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int prev_end = intervals[0][1];
        int n= intervals.length;
        for(int i=1;i<n;i++){
            if(prev_end>intervals[i][0]){
                result++;
            }else{
                prev_end=intervals[i][1];
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
		 */
	}

}
