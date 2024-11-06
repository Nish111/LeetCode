package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    List<String> suggestions = new ArrayList<>();
}

class Trie1 {
    private final TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    // Inserts a product into the Trie and maintains up to 3 lexicographical suggestions at each node
    public void insert(String product) {
        TrieNode current = root;
        for (char ch : product.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            // Add the product to the suggestions list at each node, keeping it sorted and limited to 3 entries
            if (current.suggestions.size() < 3) {
                current.suggestions.add(product);
            }
        }
    }

    // Retrieves the suggestions list for the given prefix in the Trie
    public List<String> searchByPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return new ArrayList<>(); // no products found with this prefix
            }
            current = current.children[index];
        }
        return current.suggestions;
    }
}
public class SearchSuggestionsSystem {
// https://leetcode.com/problems/search-suggestions-system/?envType=study-plan-v2&envId=leetcode-75
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    	// Sort products lexicographically
        Arrays.sort(products);
        
        // Build the Trie and insert each product
        Trie1 trie = new Trie1();
        for (String product : products) {
            trie.insert(product);
        }
        
        // Collect suggestions after each character of searchWord is typed
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        
        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            result.add(trie.searchByPrefix(prefix.toString()));
        }
        
        return result;
    }
    
    public List<List<String>> suggestedProductsBest(String[] products, String searchWord) {
        Arrays.sort(products);
        int leftIndex=0;
        int rightIndex=products.length-1;
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            char charVal=searchWord.charAt(i);
            while(leftIndex<=rightIndex){
                if(products[leftIndex].length()<=i || products[leftIndex].charAt(i)!=charVal){
                    leftIndex++;
                }
                else{
                    break;
                }
            }
            while(rightIndex>=leftIndex){
                if(products[rightIndex].length()<=i || products[rightIndex].charAt(i)!=charVal){
                    rightIndex--;
                }
                else{
                    break;
                }
            }
            int count=1;
            List<String> an=new ArrayList<>();
            for(int ii=leftIndex;ii<=rightIndex && count<=3;ii++){
                an.add(products[ii]);
                count++;
            }
            ans.add(an);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
		 */
	}

}
