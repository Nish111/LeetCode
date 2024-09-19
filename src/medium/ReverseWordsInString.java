package medium;

public class ReverseWordsInString {
// https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
	
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(temp.length() > 0) { // Avoid appending empty words (e.g., for multiple spaces)
                    sb.append(temp.reverse()).append(" ");
                    temp.setLength(0); // Clear the temp StringBuilder for the next word
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        
        // Append the last word (if any)
        if(temp.length() > 0) {
            sb.append(temp.reverse());
        }
        
        // Trim any trailing space that may have been added
        return sb.toString().trim();
    }
    public String reverseWordsBest(String s) {
        char[] c = s.toCharArray();
        char[] r = new char[c.length];

        int ri = findAndCopyWord(c, r, 0, 0);

        return new String(r, 0, ri);
    }

    private int findAndCopyWord(char[] c, char[] r, int i, int ri) {
        while(i<c.length && c[i]==' ')i++;
        int e = i;
        while(e<c.length && c[e]!=' ')e++;

        if(i==e) return ri;

        ri = findAndCopyWord(c,r,e+1, ri);

        if(ri>0) {
            r[ri]=' ';
            ri++;
        }
        for(int j=i;j<e;j++) {
            r[ri++]=c[j];
        }
        return ri;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInString rs = new ReverseWordsInString();
		String s = "the sky is blue";
		System.out.println(rs.reverseWords(s));
		/*
		 * Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
		 */
	}

}
