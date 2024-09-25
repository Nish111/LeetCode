package medium;

import java.util.Stack;

public class OnlineStockSpan {
// https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
	class StockSpanner {

		// Stack to store pairs of (price, span)
	    Stack<int[]> st;
	    public StockSpanner() {
	    	 st = new Stack<>();
	    }
	    
	    public int next(int price) {
	    	int result=1;
	    	// Pop from the stack while the current price is greater or equal to the top of the stack
	        while (!st.isEmpty() && st.peek()[0] <= price) {
	            // Add the span of the top element to the current span
	            result += st.pop()[1];
	        }
	        
	        // Push the current price along with its calculated span onto the stack
	        st.push(new int[]{price, result});
	        
	        return result;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
 * Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 */
	}

}
