package apr09042024;

public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
	       // https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
	       StringBuilder sb1 = new StringBuilder();
	       StringBuilder sb2 = new StringBuilder();
	       int count=0;
	       for(int i=0; i<s.length(); i++){
	           if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||
	           s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||
	           s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
	               sb1.append(s.charAt(i));
	               count++;
	           }
	       }
	       for(int i=0; i<s.length(); i++){
	           if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||
	           s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||
	           s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
	               sb2.append(sb1.charAt(count-1));
	               count--;
	           } else {
	               sb2.append(s.charAt(i));
	           }
	       }
	       return sb2.toString();
	   }
	public String reverseVowelsBest(String s) {
        // Step 1: Create an array to mark vowels
        boolean[] vowels = new boolean[256];
        vowels['a'] = true; vowels['e'] = true; vowels['i'] = true; vowels['o'] = true; vowels['u'] = true;
        vowels['A'] = true; vowels['E'] = true; vowels['I'] = true; vowels['O'] = true; vowels['U'] = true;

        // Step 2: Convert the string to a character array to perform swaps
        char[] strArray = s.toCharArray();

        // Step 3: Use two-pointer approach
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && !vowels[strArray[left]]) {
                left++;
            }

            // Move right pointer to the previous vowel
            while (left < right && !vowels[strArray[right]]) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = strArray[left];
                strArray[left] = strArray[right];
                strArray[right] = temp;

                left++;
                right--;
            }
        }

        // Step 4: Convert character array back to string and return it
        return new String(strArray);
    }

	public static void main(String[] args) {
		ReverseVowelsOfString rs = new ReverseVowelsOfString();
		String s = "hello";
		System.out.println(rs.reverseVowels(s));// holle
		System.out.println(rs.reverseVowels("leetcode")); // leotcede

	}
}

