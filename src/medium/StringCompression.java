package medium;

public class StringCompression {
	// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression sc = new StringCompression();
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'C' };
		System.out.println(sc.compress(chars));
		/*
		 * Example 1:
		 * 
		 * Input: chars = ["a","a","b","b","c","c","c"] Output: Return 6, and the first
		 * 6 characters of the input array should be: ["a","2","b","2","c","3"]
		 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
		 * "a2b2c3". Example 2:
		 * 
		 * Input: chars = ["a"] Output: Return 1, and the first character of the input
		 * array should be: ["a"] Explanation: The only group is "a", which remains
		 * uncompressed since it's a single character. Example 3:
		 * 
		 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"] Output:
		 * Return 4, and the first 4 characters of the input array should be:
		 * ["a","b","1","2"]. Explanation: The groups are "a" and "bbbbbbbbbbbb". This
		 * compresses to "ab12".
		 */
	}

	public int compress(char[] chars) {
		int ans = 0;

		// iterate through input array using i pointer
		for (int i = 0; i < chars.length;) {
			final char letter = chars[i]; // current character being compressed
			int count = 0; // count of consecutive occurrences of letter

			// count consecutive occurrences of letter in input array
			while (i < chars.length && chars[i] == letter) {
				++count;
				++i;
			}
			// write letter to compressed array
			chars[ans++] = letter;

			// if count is greater than 1, write count as string to compressed array
			if (count > 1) {
				// convert count to string and iterate over each character in string
				for (final char c : String.valueOf(count).toCharArray()) {
					chars[ans++] = c;
				}
			}

		}
		return ans;// return length of compressed array
	}

	public int compressBest(char[] chars) {
        int idx = 1, k = 0;
        char prev_c = chars[0]; 
        for(char c:chars){
            if(c==prev_c) k++;
            else{
                if(k>1){
                    int x = k, digit = 1;
                    while(x/digit>9) digit *= 10;
                    while(digit>=1) {
                        chars[idx++] = (char)('0'+ k/digit);
                        k = k%digit;
                        digit /= 10;
                    }
                }
                chars[idx++] = c;
                prev_c = c;
                k = 1;
            }
        }
        if(k>1){
            int x = k, digit = 1;
            while(x/digit>9) digit *= 10;
            while(digit>=1) {
                chars[idx++] = (char)('0'+ k/digit);
                k = k%digit;
                digit /= 10;
            }
        }
        return idx;
    }
}
