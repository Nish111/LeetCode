package easy;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
public class FindDifferenceOfTwoArrays {

	public List<List<Integer>> findDifferenceBest(int[] nums1, int[] nums2) {
        return new AbstractList<List<Integer>>() {
            List<Integer> first = null;
            List<Integer> second = null;

            @Override
            public List<Integer> get(int i){
                if(first==null){
                    process();
                }
                return (i==0)?first:second;
            }

            @Override
            public int size(){
                return 2;
            }

            private void process(){
                first = new ArrayList<>();
                second = new ArrayList<>();
                byte[] m1 = new byte[2001];
                byte[] m2 = new byte[2001];
                for(int i : nums2){
                    m1[i+1000]=0b1;
                }
                for(int i : nums1){
                    int x = i+1000;
                    if(m1[x]!=0b1){
                        m1[x] = 0b1;
                        first.add(i);
                    }
                    m2[x] = 0b1;
                }
                for(int i:nums2){
                    int x=i+1000;
                    if(m2[x]!=0b1){
                        m2[x] = 0b1;
                        second.add(i);
                    }
                }

            }
        };
    }
	   public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
	       ArrayList<Integer> a = new ArrayList<Integer>();
	       ArrayList<Integer> b = new ArrayList<Integer>();
	       List<List<Integer>> c = new ArrayList<>();
	       
	       HashSet<Integer> aa = new HashSet<Integer>();
	       for(int i=0; i<nums1.length; i++){
	           aa.add(nums1[i]);
	       }
	       HashSet<Integer> bb = new HashSet<Integer>();
	       for(int i=0; i<nums2.length; i++){
	           bb.add(nums2[i]);
	       }
	       for(int i : aa) {
	    	   if(!bb.contains(i)) a.add(i);
	       }
	       for(int i : bb) {
	    	   if(!aa.contains(i)) b.add(i);
	       }
	       c.add(a); c.add(b);
	       return c;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */
	}

}
