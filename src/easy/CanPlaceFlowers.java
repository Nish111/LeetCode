package easy;

public class CanPlaceFlowers {
// https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
    public boolean canPlaceFlowers(int[] flowerbed, int n) { // still some issue
        
    	int count=0;
    	int i=0, locationOfOne=0;;
    	while(i<flowerbed.length) {
    		if(flowerbed[i]==1) {
    			locationOfOne=i;
    			break;
    		}
    		else i++;
    	}
    	if(locationOfOne != 1 || locationOfOne != 0) count+=locationOfOne/2;
    	while(i<flowerbed.length) {
    		if(flowerbed[i]==1) {
    			int temp = i-locationOfOne-1;
    			if(temp%2==0) temp--;
    			count+=temp/2;
        		locationOfOne=i;
    		}
    		i++;
    	}
    	if(flowerbed[flowerbed.length-1]!=1) {
    		int temp = flowerbed.length-1-locationOfOne;
    		count+=temp/2;
    	}
    	return count>=n;
    			
    }
    public boolean canPlaceFlowersBest(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i = i + 2) {
            if (flowerbed[i] == 0) {
                if ((i == flowerbed.length - 1) || (flowerbed[i] == flowerbed[i + 1])) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        if (n <= 0)
            return true;
        else
            return false;
    }
    public boolean canPlaceFlowersWorking(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        
        // Traverse the flowerbed
        while (i < flowerbed.length) {
            // Check if the current position is empty, and the adjacent spots are also empty
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                
                // Place a flower here
                flowerbed[i] = 1;
                count++;
                
                // If we've placed enough flowers, return true
                if (count >= n) {
                    return true;
                }
                
                // Skip the next spot since we can't plant adjacent flowers
                i += 2;
            } else {
                // Move to the next spot
                i++;
            }
        }
        
        // Return true if we could place the required number of flowers, otherwise false
        return count >= n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanPlaceFlowers cpf = new CanPlaceFlowers();
		int[] a = {1,0,0,0,1};
		System.out.println(cpf.canPlaceFlowers(a, 1)); // true
		System.out.println(cpf.canPlaceFlowers(a, 2)); // false
		int[] b = {1,0,0,0,0,1};
		System.out.println(cpf.canPlaceFlowers(b, 2)); // false
		int[] c = {1,0,0,0,1,0,0};
		System.out.println(cpf.canPlaceFlowers(c, 2)); // true
		
		/*
		 * Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
		 */
	}

}
