package medium;

public class OddEvenLinkedList {
// https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenLinkedList oel = new OddEvenLinkedList();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = null;
		oel.oddEvenList(one);
	}

}
