package medium;

public class RemovingStartsFromAString {
// https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
	public String removeStars(String s) {
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == '*') {
				// Remove the last character in the StringBuilder when a '*' is encountered
				sb.deleteCharAt(sb.length() - 1);
			} else {
				// Add the character to the result
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public String removeStars1(String s) { // Best
		int len = s.length();
		byte[] result = new byte[len];
		s.getBytes(0, len, result, 0);
		int stars = 0;
		for (int i = 0; i < len; i++) {
			if (result[i] == '*') {
				stars++;
			} else {
				result[i - stars * 2] = result[i];
			}
		}
		return new String(result, 0, len - stars * 2);

		/*
		 * //int count=0; StringBuilder sb = new StringBuilder();
		 * 
		 * for(int i=0; i<s.length(); i++) { char temp = s.charAt(i); if(temp=='*')
		 * count++; }
		 * 
		 * int count=0; int res=0; for(int i=s.length()-1; i>=0; i--){ char temp =
		 * s.charAt(i); if(temp=='*') break; if(temp!='*') { sb.append(temp); res=i;
		 * break; } } for(int i=res-1; i>=0; i--){ char temp = s.charAt(i);
		 * if(temp=='*') { int j=i;
		 * 
		 * while(j>=0 & s.charAt(j)=='*') { count++; j--; } if(count>0) i=i-count+1; }
		 * else if(count==0){ sb.append(temp); } else count--;
		 * 
		 * } return sb.reverse().toString();
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemovingStartsFromAString rs = new RemovingStartsFromAString();
		String a = "leet**cod*e";
		System.out.println(rs.removeStars(a));
		String b = "erase*****";
		System.out.println(rs.removeStars(b));
		String c = "abb*cdfg*****x*";
		System.out.println(rs.removeStars(c));
	}
	/*
	 * Example 1:
	 * 
	 * Input: s = "leet**cod*e" Output: "lecoe" Explanation: Performing the removals
	 * from left to right: - The closest character to the 1st star is 't' in
	 * "leet**cod*e". s becomes "lee*cod*e". - The closest character to the 2nd star
	 * is 'e' in "lee*cod*e". s becomes "lecod*e". - The closest character to the
	 * 3rd star is 'd' in "lecod*e". s becomes "lecoe". There are no more stars, so
	 * we return "lecoe". Example 2:
	 * 
	 * Input: s = "erase*****" Output: "" Explanation: The entire string is removed,
	 * so we return an empty string.
	 */
}
