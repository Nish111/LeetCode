package medium;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DetermineIfTwoStringsAreClose {
// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
    public boolean closeStrings(String word1, String word2) {
    	if(word1.length() != word2.length()) return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        for(char i : word1.toCharArray()) {
        	hm1.put(i, hm1.getOrDefault(i, 0)+1);
        }
        for(char i : word2.toCharArray()) {
        	hm2.put(i, hm2.getOrDefault(i, 0)+1);
        }
        // Compare character sets
        if (!hm1.keySet().equals(hm2.keySet())) {
            return false;
        }
        ArrayList<Integer> test1 = new ArrayList<>(hm1.values());
        ArrayList<Integer> test2 = new ArrayList<>(hm2.values());
        Collections.sort(test1);
        Collections.sort(test2);

        return test1.equals(test2);
    }
    public boolean closeStringsBest(String word1, String word2) {
        int n = word1.length();
        if (n != word2.length())  return false;
        if (word1.equals(word2))  return true;

        int[] freq1 = new int['z' + 1];
        int[] freq2 = new int['z' + 1];
        byte[] w = new byte[n];
        word1.getBytes(0, n, w, 0);
        for (byte c : w)  freq1[c]++;
        word2.getBytes(0, n, w, 0);
        for (byte c : w)  freq2[c]++;

        for (int i = 'a'; i <= 'z'; i++)
            if (freq1[i] == 0 ^ freq2[i] == 0)
                return false;

        freq1['a' - 1] = -1;
        for (int i, k = 'a'; ++k <= 'z';) {
            int f1i = freq1[i = k];
            while (f1i < freq1[--i])  freq1[i + 1] = freq1[i];
            freq1[i + 1] = f1i;
        }

        freq2['a' - 1] = -1;
        for (int i, k = 'a'; ++k <= 'z';) {
            int f2i = freq2[i = k];
            while (f2i < freq2[--i])  freq2[i + 1] = freq2[i];
            freq2[i + 1] = f2i;
        }

        for (int i = 'a'; i <= 'z'; i++)
            if (freq1[i] != freq2[i])
                return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetermineIfTwoStringsAreClose dc = new DetermineIfTwoStringsAreClose();
		System.out.println(dc.closeStrings("abc","bca")); // true
		System.out.println(dc.closeStrings("a","aa")); // false
		System.out.println(dc.closeStrings("cabbba","abbccc")); // true
		System.out.println(dc.closeStrings("uau","ssx")); // false
		/*
		 * Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
		 */
	}

}
