package easy;

public class IsSubsequence {
	 public boolean isSubsequence(String s, String t) {
	       int n = t.length();
	       int m = s.length();
	       int i=0, j=0, count=0;
	       if(m>n) return false;
	       while(i<n & j<m){
	           if(s.charAt(j)==t.charAt(i)){
	               i++; j++; count++;
	           }
	           else {
	               i++;
	           }
	       }
	       if(count==m) return true;
	       else return false;
	    }
	    public boolean isSubsequence2(String s, String t) { // maybe fastest
	        // final int sLength = s.length();
	        // if (sLength == 0) return true;
	        if (s.length() == 0) return true;
	        int matched = 0;
	        for (char c : t.toCharArray()) {
	            if (c == s.charAt(matched) && ++matched == s.length()) {
	            // if (c == s.charAt(matched) && ++matched == sLength) {
	                // matched++;
	                // if (++matched == sLength) 
	                    return true;
	            }
	        }
	        return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubsequence is = new IsSubsequence();
		System.out.println(is.isSubsequence("abc", "ahbgdc"));
	}
	/*
	 * Example 1:

	Input: s = "abc", t = "ahbgdc"
	Output: true
	Example 2:

	Input: s = "axc", t = "ahbgdc"
	Output: false
	 
	 */
}
