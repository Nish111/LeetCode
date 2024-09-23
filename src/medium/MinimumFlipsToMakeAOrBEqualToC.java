package medium;

public class MinimumFlipsToMakeAOrBEqualToC {
// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75
    public int minFlipsN(int a, int b, int c) {
    	//int temp = (a+b)%c;
        //return Math.min(temp, Math.abs(temp-c));
    	if(a<=c && b<=c) {
    		if(a==c || b==c) return 0;
    	}
    	int temp = Math.abs((a+b)^c);
        int res=0;
        while(temp>0){
            temp = temp & (temp-1); // converting to binary
            res = res+1;
        }
        return res;
    }
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        // We go bit by bit, until all bits of a, b, and c are processed
        while (a > 0 || b > 0 || c > 0) {
            // Extract the last bits of a, b, and c using bitwise AND with 1
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            // Check conditions:
            if (bitC == 0) {
                // Both a and b must be 0, so flip if either is 1
                if (bitA == 1 || bitB == 1) {
                    flips += (bitA == 1 ? 1 : 0) + (bitB == 1 ? 1 : 0);
                }
            } else { // bitC == 1
                // At least one of a or b must be 1, so flip if both are 0
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            // Shift a, b, and c to the right to process the next bits
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumFlipsToMakeAOrBEqualToC mf = new MinimumFlipsToMakeAOrBEqualToC();
		System.out.println(mf.minFlips(2, 6, 5)); // 3
		System.out.println(mf.minFlips(4, 2, 7)); // 1
		System.out.println(mf.minFlips(1, 2, 3)); // 0
		System.out.println(mf.minFlips(7, 7, 7)); // 0
		System.out.println(mf.minFlips(7, 5, 7)); // 0
		System.out.println(mf.minFlips(8, 3, 5)); // 3
		System.out.println(mf.minFlips(10, 9, 1)); // 3 -- 2
		/*
		 * Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0
 
		 */
	}

}
