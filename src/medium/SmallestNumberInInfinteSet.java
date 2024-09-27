package medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestNumberInInfinteSet {
// https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
	
	class SmallestInfiniteSet {

		private PriorityQueue<Integer> minHeap;  // To store and pop the smallest element
	    private HashSet<Integer> set;            // To track which elements are currently in the set
	    private int current;                     // Tracks the smallest element not yet popped

	    public SmallestInfiniteSet() {
	    	minHeap = new PriorityQueue<>();
	        set = new HashSet<>();
	        current = 1;
	        
	    }
	    
	    public int popSmallest() {
	    	if (!minHeap.isEmpty()) {
	            int smallest = minHeap.poll();  // Get the smallest element from the minHeap
	            set.remove(smallest);           // Remove it from the tracking set
	            return smallest;
	        }
	        return current++;   // If no smaller elements are in the heap, return current and increment
	 
	    }
	    
	    public void addBack(int num) {
	    	if (num < current && !set.contains(num)) {
	            minHeap.offer(num);  // Add back to the heap
	            set.add(num);        // Track that the element is back in the set
	        }
	    }
	}
	class SmallestInfiniteSetBest {
	    private byte[] a;
	    private int minIndex;
	    public SmallestInfiniteSetBest() {
	        this.a=new byte[1001];
	        this.minIndex=0;
	    }
	    
	    public int popSmallest() {
	        while(a[minIndex++]==1);
	        a[minIndex-1]=1;
	        return minIndex;
	    }
	    
	    public void addBack(int num) {
	        a[num-1]=0;
	        minIndex = Math.min(minIndex,num-1);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //SmallestInfiniteSet obj = new SmallestInfiniteSet();
		 //int param_1 = obj.popSmallest();
		 //obj.addBack(param_1);
	}
/*
 * Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 
 */
}
