package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountingBits {
// https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		result[0] = 0;
		for (int i = 1; i <= n; i++) {

			int temp = i;
			while (temp > 0) {

				result[i] += temp % 2;
				temp /= 2;
			}
		}
		return result;
	}
	public int[] countBitsBest(int n) {
        int[] dp = new int[n+1];
        rec(dp, 1, 1);
        return dp;
    }

    void rec(int[] dp, int index, int ones) {
        if(index >= dp.length) return;
        dp[index] = ones;

        rec(dp, index*2, ones);
        rec(dp, index*2 + 1, ones +1);
    }
    public int[] countBits2(int n) {
        int arr[] = new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = countSetBits(i);
        }
        return arr;
    }
    int countSetBits(int n){
        int res=0;
        while(n>0){
            n = n & (n-1); // converting to binary
            res = res+1;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingBits cb = new CountingBits();
		int[] a = cb.countBits(2);
		IntStream.range(0, a.length).forEach(i -> {
			System.out.println(a[i]);
		});
		int[] b = cb.countBits(5);
		IntStream.range(0, b.length).forEach(i -> {
			System.out.println(b[i]);
		});
		/*
		 * Example 1:
		 * 
		 * Input: n = 2 Output: [0,1,1] Explanation: 0 --> 0 1 --> 1 2 --> 10 Example 2:
		 * 
		 * Input: n = 5 Output: [0,1,1,2,1,2] Explanation: 0 --> 0 1 --> 1 2 --> 10 3
		 * --> 11 4 --> 100 5 --> 101
		 */
	}

}
