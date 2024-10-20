package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=leetcode-75
	  // Mapping of digits to corresponding letters on a phone keypad
    private static final String[] KEYPAD = {
        "",     // 0 does not map to any letters
        "",     // 1 does not map to any letters
        "abc",  // 2 maps to "abc"
        "def",  // 3 maps to "def"
        "ghi",  // 4 maps to "ghi"
        "jkl",  // 5 maps to "jkl"
        "mno",  // 6 maps to "mno"
        "pqrs", // 7 maps to "pqrs"
        "tuv",  // 8 maps to "tuv"
        "wxyz"  // 9 maps to "wxyz"
    };
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base case: if the input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start the backtracking process
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    // Helper function for backtracking
    private static void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        // If we've processed all digits, add the current combination to the result
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        // Get the current digit as an integer
        int digit = digits.charAt(index) - '0';
        
        // Get the corresponding letters for this digit
        String letters = KEYPAD[digit];
        
        // Loop through each letter and continue building the combination
        for (char letter : letters.toCharArray()) {
            combination.append(letter);  // Add the current letter
            backtrack(result, combination, digits, index + 1);  // Recurse to the next digit
            combination.deleteCharAt(combination.length() - 1);  // Backtrack (remove the last letter)
        }
    }
    /*
     * Approach:
Base Case: If the input string is empty, return an empty list.
Backtracking: We define a recursive backtracking function to explore all possible combinations of letters.
For each digit, we look up the corresponding set of letters.
Recursively build the string by appending one letter from the current digit's set, and then move on to the next digit.
Once we have processed all digits, we add the generated string to the result.
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
		 */
	}

}
