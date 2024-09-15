package medium;

public class MaximumTwinSumOfLinkedList {
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
	private static int[] a = new int[100000];

	public int pairSumBest(ListNode head) {
		final int[] arr = a;
		int size = 0;
		while (head != null) {
			arr[size++] = head.val;
			head = head.next;
		}

		int m = size / 2;
		int maxSum = 0;
		for (int i = 0; i < m; i++) {
			--size;
			if (arr[i] + arr[size] > maxSum) {
				maxSum = arr[i] + arr[size];
			}
		}
		return maxSum;
	}

	public int pairSum(ListNode head) {
		if (head == null || head.next == null)
			return head.val;

		// Step 1: Find the middle of the linked list using the slow and fast pointer
		// approach
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the list (starting from `slow`)
		ListNode prev = null, current = slow, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		// Step 3: Now, `prev` is the head of the reversed second half of the list
		ListNode firstHalf = head;
		ListNode secondHalf = prev;
		int maxPairSum = 0;

		// Step 4: Compare the first half with the reversed second half and compute pair
		// sum
		while (secondHalf != null) {
			maxPairSum = Math.max(maxPairSum, firstHalf.val + secondHalf.val);
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		return maxPairSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
