package easy;

public class ContainerWithMostWater {
// https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
    public int maxArea(int[] height) {
    	int max=0, i=0, j=height.length-1;
    	while(i<j) {
    		int temp = Math.min(height[i], height[j])*(j-i);
    		max = Math.max(max, temp);
            // Move the pointer of the smaller height inward
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
    	}
        return max;
    }
    public int maxAreaBest(int[] height) {
        /*
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while(left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }         

         return maxArea;
        */

        // another approch
         int maxLength=0;
        int area=0,min=0;
        int i=0,j=height.length-1;   
        while(i<j)
        {
          min= Math.min(height[i],height[j]);
          maxLength=Math.max(maxLength,(j-i)*(min));
            while(i<j&&height[i]<=min) i++;
            while(i<j&&height[j]<=min) j--;
            
        }
        return maxLength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater cm = new ContainerWithMostWater();
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(cm.maxArea(a)); // 49
		System.out.println(cm.maxArea(new int[] {1, 1})); // 1
		int[] b = {2,3,4,5,18,17,6};
		System.out.println(cm.maxArea(b)); // 17
/*
 * Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 */
	}

}
