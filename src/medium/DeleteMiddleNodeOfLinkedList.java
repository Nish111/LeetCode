package medium;
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class DeleteMiddleNodeOfLinkedList {
	//Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 public ListNode deleteMiddle2(ListNode head) {
	       //count size and then skip size/2
	       ListNode temp = head;
	       int count=0;
	       while(temp.next != null){
	           temp = temp.next;
	           count++;
	       }
	       temp = head;
	       //if(count%2!=0) count++;
	       count /=2;  
	       while(count>0){
	           temp=temp.next;
	           count--;
	       }
	       temp.next = temp.next.next;
	       return head;
	   }
	 public ListNode deleteMiddleBest(ListNode head) {
			    if (head.next == null||head==null)
			        return null;
			    ListNode slow = head;
			    ListNode fast = head.next.next;
			    while (fast != null && fast.next != null) {
			        fast = fast.next.next;
			        slow = slow.next;
			    }
			    slow.next = slow.next.next;
			    return head;
			    }
	 public ListNode deleteMiddle(ListNode head) {
		    // Edge case: if the list contains only one node, return null
		    if (head == null || head.next == null) {
		        return null;
		    }

		    // Count the size of the list
		    ListNode temp = head;
		    int count = 0;
		    
		    while (temp != null) {
		        temp = temp.next;
		        count++;
		    }
		    
		    // Find the middle node (integer division)
		    int middle = count / 2;
		    
		    // Reset temp to head to iterate again to the middle node
		    temp = head;
		    ListNode prev = null; // To keep track of the previous node
		    
		    // Move to the middle node
		    while (middle > 0) {
		        prev = temp;
		        temp = temp.next;
		        middle--;
		    }

		    // Skip the middle node by adjusting the previous node's next pointer
		    prev.next = temp.next;
		    
		    return head;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
