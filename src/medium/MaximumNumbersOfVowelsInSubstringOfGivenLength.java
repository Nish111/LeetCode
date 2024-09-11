package medium;

public class MaximumNumbersOfVowelsInSubstringOfGivenLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNumbersOfVowelsInSubstringOfGivenLength mn =
				new MaximumNumbersOfVowelsInSubstringOfGivenLength();
		String s = "abciiidef";
		int k = 3;
		System.out.println(mn.maxVowels(s, 3));

	}
    public int maxVowels(String s, int k) {
        int max=0;
        int temp=0;
        int start=0;
        int e = k-1;
        for(int i=start; i<=e; i++){
            if(s.charAt(i)=='a'|| s.charAt(i)=='e'|| s.charAt(i)=='i'||
            s.charAt(i)=='o'|| s.charAt(i)=='u') {
                temp++;
            }
        }
        max = temp;
        for(int i=1; i<s.length()-k+1; i++){
            if(s.charAt(i-1)=='a'|| s.charAt(i-1)=='e'|| s.charAt(i-1)=='i'||
            s.charAt(i-1)=='o'|| s.charAt(i-1)=='u') {
                temp--;
            }
            if(s.charAt(i+k-1)=='a'|| s.charAt(i+k-1)=='e'|| s.charAt(i+k-1)=='i'||
            s.charAt(i+k-1)=='o'|| s.charAt(i+k-1)=='u') {
                temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
 
	public int maxVowelsBest(String s, int k) {
		int maxLen = 0;

		        int[] vowels = new int[26];
		        vowels['a'-'a'] = 1;
		        vowels['e'-'a'] = 1;
		        vowels['i'-'a'] = 1;
		        vowels['o'-'a'] = 1;
		        vowels['u'-'a'] = 1;

		        int count = 0;
		        int left = 0;

		        for(int right=0; right<s.length(); right++) {
		            
		            char ch = s.charAt(right);
		            count += vowels[ch-'a'];


		            if(right >= k-1) {

		                maxLen = Math.max(maxLen, count);
		                char c = s.charAt(left);

		                if(vowels[c-'a'] != 0) {
		                    count--;
		                }
		                left++;
		            }
		        }
		        return maxLen;
		   }

}
