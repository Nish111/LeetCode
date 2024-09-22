package medium;

import java.util.Stack;

public class DecodeString {
// https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
	
	public String decodeStringBest(String s) {
        Stack<Integer> counts=new Stack<>();
        Stack<StringBuilder> res=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count=0;
                while(Character.isDigit(s.charAt(i))){
                    count=count*10+(s.charAt(i)-'0');
                    i++;
                }
                counts.push(count);
            }
            else if(s.charAt(i)=='['){
                res.push(curr);
                curr=new StringBuilder();
                i++;
            }
            else if(s.charAt(i)==']'){
                StringBuilder temp=curr;
                curr=res.pop();
                int count=counts.pop();
                for(int j=0;j<count;j++){
                    curr.append(temp);
                }
                i++;
            }
            else{
                curr.append(s.charAt(i));
                i++;
            }
        }
        return curr.toString();
    }
    public String decodeString(String s) {
        
    	 Stack<Integer> countStack = new Stack<>();
         Stack<String> resultStack = new Stack<>();
         String currentStr = "";
         int currentNum = 0;

         for (char ch : s.toCharArray()) {
             if (Character.isDigit(ch)) {
                 // If character is a digit, update the current number (for multi-digit numbers)
                 currentNum = currentNum * 10 + (ch - '0');
             } else if (ch == '[') {
                 // Push the current number and string to their respective stacks
                 countStack.push(currentNum);
                 resultStack.push(currentStr);

                 // Reset current number and string for the next section
                 currentNum = 0;
                 currentStr = "";
             } else if (ch == ']') {
                 // Pop count and previous string, then repeat the current string
                 int repeatCount = countStack.pop();
                 StringBuilder sb = new StringBuilder(resultStack.pop());
                 for (int i = 0; i < repeatCount; i++) {
                     sb.append(currentStr);
                 }
                 currentStr = sb.toString();
             } else {
                 // Append letters to the current string
                 currentStr += ch;
             }
         }

         return currentStr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString ds = new DecodeString();
		
		 System.out.println(ds.decodeString("3[a]2[bc]"));        // Output: "aaabcbc"
	        System.out.println(ds.decodeString("3[a2[c]]"));         // Output: "accaccacc"
	        System.out.println(ds.decodeString("2[abc]3[cd]ef"));    // Output: "abcabccdcdcdef"

		/*
		 * Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
		 */
	}

}
