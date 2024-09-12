package medium;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KidsWithGreatestNumberOfCandies kc = new KidsWithGreatestNumberOfCandies();
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		ArrayList<Boolean> ar = (ArrayList<Boolean>) kc.kidsWithCandies(candies, extraCandies);
				//Output: [true,true,true,false,true] 

	}
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
       for(int i=0; i<candies.length; i++){
           if(candies[i]>max){
               max = candies[i];
           }
       }
       List<Boolean> result = new ArrayList<>();
       for(int i=0; i<candies.length; i++){
           if(candies[i]+extraCandies>=max){
               result.add(true);
           } else {
               result.add(false);
           }
       }
       return result;
    }
	public List<Boolean> kidsWithCandiesBest(int[] candies, int extraCandies) {

        // Step 1: Find the maximum value in the candies array
        int biggest = candies[0];
        for (int candy : candies) {
            if (candy > biggest) {
                biggest = candy;
            }
        }

        // Step 2: Initialize the result list with a known size
        List<Boolean> res = new ArrayList<>(candies.length);

        // Step 3: Iterate through the candies array and populate the result
        for (int candy : candies) {
            res.add(candy + extraCandies >= biggest);
        }

        return res;
    }

}
