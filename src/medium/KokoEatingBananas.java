package medium;

import java.util.Arrays;

public class KokoEatingBananas {
// https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();  // Upper bound is the largest pile
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, mid, h)) {
                result = mid;  // Update result to try for a smaller value
                high = mid - 1;
            } else {
                low = mid + 1;  // Need to increase the speed
            }
        }

        return result;
    }
    private boolean canEatAll(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += Math.ceil((double) pile / k);  // Calculate the hours for each pile
        }
        return hoursNeeded <= h;  // Return true if Koko can finish within h hours
    }
    public int minEatingSpeedBest(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for(int p : piles){
            total += p;
        }
        int left = (int) ((total - 1) / h) + 1;//minimum number of bananas she eats per hour.
        int right = (int) ((total - n) / (h - n + 1)) + 1;//assuming she eats all the bananas from the biggest pile in 1 hour and then waits takes her time with the rest.
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {//calculating the total time it takes to eat the rest of the bananas at the current rate without using pointers.
                time += (p - 1) / mid + 1;
            }
            if (time > h) {//if the time currently is greater than h we should increase the min time.
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;//since we need the minimum integer where she can eat all the bananas within the time.
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
		 */
	}

}
