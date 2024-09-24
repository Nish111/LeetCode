package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SuccessfulPairsOfSpellsAndPotions {
// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int[] successfulPairsN(int[] spells, int[] potions, long success) {
    	Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for(int i=0; i<spells.length; i++) {
        	for(int j=0; j<potions.length; j++) {
        		long temp = spells[i]*potions[j];
        		if(temp>=success) {
        			pairs[i]=potions.length-j;
        			break;
        		}
        	}
        }
        return pairs;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Sort the potions array for binary search
        int[] pairs = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            // For each spell, perform binary search to find the first potion
            // where spell * potion >= success
            int low = 0;
            int high = potions.length;
            
            while (low < high) {
                int mid = (low + high) / 2;
                // If the product of the spell and the potion is less than the required success value
                if ((long) spells[i] * potions[mid] < success) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            
            // The number of successful pairs is the number of potions from the current index to the end
            pairs[i] = potions.length - low;
        }
        
        return pairs;
    }
    public int[] successfulPairsBest(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m= potions.length;

        int maxp = potions[0];
        for (int i = 1; i < m; i++) {
            if (maxp < potions[i]) {
                maxp = potions[i];
            }
        }

        int[] pcouners = new int[maxp + 1];
        for (int i = 0; i <m; i++) {
            pcouners[potions[i]]++;
        }

        for (int i = maxp - 1; i > 0; i--) {
            pcouners[i] += pcouners[i + 1];
        }

        long mins = (success + maxp - 1) / maxp;
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int res = 0;

            if (spell >= mins) {
                long ptarget = (success + spell - 1) / spell;
                res = pcouners[(int) ptarget];
            }

            spells[i] = res;
        }
        
        return spells;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuccessfulPairsOfSpellsAndPotions sp = new SuccessfulPairsOfSpellsAndPotions();
		int[] spells = {5,1,3}; 
		int[] potions = {1,2,3,4,5};
		int[] a = sp.successfulPairs(spells, potions, 7);
		 IntStream.range(0, a.length).forEach(i -> 
	        {  System.out.println(a[i]);
	        });
		/*
		 * Example 1:

Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.
Example 2:

Input: spells = [3,1,2], potions = [8,5,8], success = 16
Output: [2,0,2]
Explanation:
- 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
- 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful. 
- 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful. 
Thus, [2,0,2] is returned.
 
		 */
	}

}
