package medium;

import java.util.PriorityQueue;

public class TotalCosstToHireKWorkers {
// https://leetcode.com/problems/total-cost-to-hire-k-workers/?envType=study-plan-v2&envId=leetcode-75
	public long totalCostBest(int[] costs, int k, int candidates) {
        int len = costs.length;
        long cost = 0;

        int[] l = new int[candidates];
        int[] r = new int[candidates];

        int left = 0; int right = len-1;
        for (left = 0; left < candidates; left++) {
            l[left] = costs[left];
        }
        for (int i = 0; i < candidates; i++) {
            if (right < candidates) {
                r[i] = Integer.MAX_VALUE;
            } else {
                r[i] = costs[right--];
            }
        }

        buildMinHeap(l);
        buildMinHeap(r);

        while (k-- > 0) {
            if (r[0] < l[0]) {
                cost += r[0];
                r[0] = left <= right ? costs[right--] : Integer.MAX_VALUE;
                minHeapify(r, 1); // to check if r[0] is less than its child nodes
            } else {
                cost += l[0];
                l[0] = left <= right ? costs[left++] : Integer.MAX_VALUE;
                minHeapify(l, 1);
            }
        }
        return cost;
    }

    public void buildMinHeap(int[] arr) {
        for (int mid = arr.length/2; mid > 0; mid--) {
            minHeapify(arr, mid);
        }
    }

    public void minHeapify(int[] arr, int mid) {
        // left and right are child nodes for node mid-1
        int left = mid*2-1; int right = mid*2; int n = arr.length;
        if (left < n && right < n) {
            left = arr[left] > arr[right] ? right : left;
            if (arr[left] < arr[mid-1]) {
                swap(arr, left, mid-1); // swapped left upward
                // left+1 since that'll check if the node left+1-1=left is smaller than children
                minHeapify(arr, left+1);
            }
        } else if (left < n && arr[left] < arr[mid-1]) {
            swap(arr, left, mid-1);
            minHeapify(arr, left+1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public long totalCost2(int[] costs, int k, int candidates) {
        long retval = 0;
        int used = 0, left = 0, right = costs.length - 1;

        // Custom comparator: prioritize by cost, and for ties, prioritize by index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> costs[a[1]] == costs[b[1]] ? a[1] - b[1] : costs[a[1]] - costs[b[1]]
        );

        // Initial population of the priority queue from both sides
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{1, left}); // 1 indicates left part
            left++;
            if (left <= right) {
                pq.offer(new int[]{0, right}); // 0 indicates right part
                right--;
            }
        }

        // Process hiring sessions
        while (used < k && !pq.isEmpty()) {
            int[] entry = pq.poll();
            boolean fromLeft = entry[0] == 1;
            int idx = entry[1];

            retval += costs[idx];
            
            if (fromLeft && left <= right) {
                pq.offer(new int[]{1, left++});
            } else if (!fromLeft && left <= right) {
                pq.offer(new int[]{0, right--});
            }
            
            used++;
        }

        return retval;
    }
    public long totalCost1(int[] costs, int k, int candidates) { // in progress
    	long result=0;
    	PriorityQueue<Integer> pqLeft = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> pqRight = new PriorityQueue<Integer>();
    	for(int i=0; i<candidates; i++) {
    		pqLeft.add(costs[i]);
    		pqRight.add(costs[costs.length-1-i]);
    		
    	}
    	while(k>0) {
    		if(pqLeft.peek()<=pqRight.peek()) {
    			result+=pqLeft.poll();
    		}
    		else result+=pqRight.poll();
    		k--;
    	}
    	return result;
        
    }
    public long totalCost(int[] costs, int k, int candidates) { // not working
        // Priority Queues (Min-Heaps)
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Pointers for left and right sides of the array
        int leftPtr = 0, rightPtr = costs.length - 1;

        // Initialize the heaps with the first and last 'candidates' elements
        for (int i = 0; i < candidates; i++) {
            if (leftPtr <= rightPtr) {
                leftHeap.add(new int[] {costs[leftPtr], leftPtr});
                leftPtr++;
            }
            if (leftPtr <= rightPtr && rightHeap.size() < candidates) {
                rightHeap.add(new int[] {costs[rightPtr], rightPtr});
                rightPtr--;
            }
        }

        long totalCost = 0;

        // Hire 'k' workers
        for (int i = 0; i < k; i++) {
            // Compare top elements of both heaps and choose the one with lower cost
            if (!leftHeap.isEmpty() && !rightHeap.isEmpty()) {
                if (leftHeap.peek()[0] <= rightHeap.peek()[0]) {
                    totalCost += leftHeap.poll()[0];
                } else {
                    totalCost += rightHeap.poll()[0];
                }
            } else if (!leftHeap.isEmpty()) {
                totalCost += leftHeap.poll()[0];
            } else {
                totalCost += rightHeap.poll()[0];
            }

            // Replenish the heaps from the remaining workers
            if (leftPtr <= rightPtr) {
                if (!leftHeap.isEmpty() && leftHeap.peek()[1] < leftPtr) {
                    leftHeap.add(new int[] {costs[leftPtr], leftPtr});
                    leftPtr++;
                } else if (!rightHeap.isEmpty() && rightHeap.peek()[1] > rightPtr) {
                    rightHeap.add(new int[] {costs[rightPtr], rightPtr});
                    rightPtr--;
                }
            }
        }

        return totalCost;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalCosstToHireKWorkers tw = new TotalCosstToHireKWorkers();
		int[] A = {17,12,10,2,7,2,11,20,8};
		System.out.println(tw.totalCost(A, 3, 4));
		/*
		 * Example 1:

Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
Output: 11
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
The total hiring cost is 11.
Example 2:

Input: costs = [1,2,4,1], k = 3, candidates = 3
Output: 4
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
- In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
- In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
The total hiring cost is 4.
		 */
	}

}
