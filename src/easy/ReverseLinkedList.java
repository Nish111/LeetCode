package easy;

import java.util.ArrayList;
// https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
public class ReverseLinkedList {

	 public ListNode reverseList(ListNode head) {
		 if(head==null || head.next==null) return head;
		    // Initialize three pointers for the iterative reversal process
		    ListNode prev = null;      // Previous node starts as null
		    ListNode current = head;   // The current node starts at the head
		    ListNode next = null;      // To store the next node temporarily during traversal

		    // Iterate over the list and reverse the pointers
		    while (current != null) {
		        next = current.next;   // Store the next node
		        current.next = prev;   // Reverse the current node's pointer to the previous node
		        prev = current;        // Move the previous node pointer forward
		        current = next;        // Move the current node pointer forward
		    }

		    // At the end, prev will be the new head of the reversed list
		    return prev;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

