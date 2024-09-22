package easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCells {
// https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
	class RecentCounter {

	    // A queue to store the timestamps of the recent pings
	    private Queue<Integer> queue;

	    // Constructor initializes the queue
	    public RecentCounter() {
	        queue = new LinkedList<>();
	    }

	    // Method to add a new ping and return the number of pings within the last 3000 milliseconds
	    public int ping(int t) {
	        // Add the new ping timestamp to the queue
	        queue.add(t);
	        
	        // Remove any pings that are older than 3000 milliseconds from the current time t
	        while (queue.peek() < t - 3000) {
	            queue.poll(); // Remove the oldest ping outside the time range
	        }
	        
	        // The size of the queue is the number of pings within the last 3000 milliseconds
	        return queue.size();
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
		 */
	}

}
