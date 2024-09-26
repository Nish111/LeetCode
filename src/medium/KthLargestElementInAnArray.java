package medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minQ = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
        	minQ.add(nums[i]);
        	if(minQ.size()>k) minQ.poll();
        }
       
        return minQ.peek();
    }
    public int findKthLargestBest(int[] nums, int k) {
        int arr[]=new int[2*10001];
        for(int n: nums) {
            arr[n+10000]++;
        }
        
        for(int i=arr.length-1; i>=0; i--) {
            k-=arr[i];
            if(k<=0) {
                return i-10000;
            }
        }
        
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KthLargestElementInAnArray kl = new KthLargestElementInAnArray();
		int[] a = {3,2,1,5,6,4};
		System.out.println(kl.findKthLargest(a, 2));
		int[] b = {3,2,3,1,2,4,5,5,6};
		System.out.println(kl.findKthLargest(b, 4));
		/*
		 * Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
		 */
	}

}
