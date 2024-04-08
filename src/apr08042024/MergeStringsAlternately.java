package apr08042024;
import java.util.*;
public class MergeStringsAlternately {
	// https://leetcode.com/problems/merge-strings-alternately/submissions/1226657063/?envType=study-plan-v2&envId=leetcode-75
    public String mergeAlternately(String word1, String word2) {
       int len1 = word1.length();
       int len2 = word2.length();
       int smaller = len1<len2?len1:len2;
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<smaller; i++){
    	   sb.append(word1.charAt(i));
           sb.append(word2.charAt(i));
       }
       if(len1==smaller){
           for(int i=smaller; i<len2; i++){
               sb.append(word2.charAt(i));
           }
       } else if (len2==smaller){
           for(int i=smaller; i<len1; i++){
               sb.append(word1.charAt(i));
           }
       }
       return sb.toString();
    }
    public static void main(String[] args) {
		MergeStringsAlternately msa = new MergeStringsAlternately();
		String word1 = "abc";
		String Word2 = "pqr";
		System.out.println(msa.mergeAlternately(word1, Word2)); // apbqcr
	}
}