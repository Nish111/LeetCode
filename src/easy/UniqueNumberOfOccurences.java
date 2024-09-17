package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueNumberOfOccurences {
// https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
	public boolean uniqueOccurrencesBest(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : arr) {
			// min = Math.min(min, i);
			// max = Math.max(max, i);
			if (min > i)
				min = i;
			if (max < i)
				max = i;
		}

		int offset = -min;
		int range = max - min + 1;

		int[] count = new int[range];

		for (int i : arr)
			count[i + offset]++;

		boolean[] used = new boolean[arr.length + 1];

		for (int i : count) {
			if (i > 0) {
				if (used[i])
					return false;
				used[i] = true;
			}
		}
		return true;
	}

	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> unique = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			unique.put(arr[i], unique.getOrDefault(arr[i], 1) + 1);
		}
		HashSet<Integer> hs = new HashSet<>();

		// Iterating HashMap through for loop
		for (Entry<Integer, Integer> s : unique.entrySet()) {
			hs.add(s.getValue());
		}

		if (hs.size() != unique.size())
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueNumberOfOccurences uo = new UniqueNumberOfOccurences();
		int[] a = { 1, 2, 2, 1, 1, 3 };
		System.out.println(uo.uniqueOccurrences(a));

		/*
		 * Example 1:
		 * 
		 * Input: arr = [1,2,2,1,1,3] Output: true Explanation: The value 1 has 3
		 * occurrences, 2 has 2 and 3 has 1. No two values have the same number of
		 * occurrences. Example 2:
		 * 
		 * Input: arr = [1,2] Output: false Example 3:
		 * 
		 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
		 */
	}

}
