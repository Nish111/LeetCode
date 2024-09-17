package easy;
// https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
public class FindPivotIndex {
	   public int pivotIndex(int[] nums) { // this is best

	       int[] pf = new int[nums.length+1];
	       int[] sf = new int[nums.length+1];
	       pf[0] = 0;
	       sf[nums.length]=0;
	       // Calculate prefix sum
	       for (int i = 1; i <= nums.length; i++) {
	           pf[i] = pf[i - 1] + nums[i - 1]; // Correct indexing for nums
	       }
	       
	       // Calculate suffix sum
	       for (int i = nums.length - 1; i >= 0; i--) {
	           sf[i] = sf[i + 1] + nums[i]; // Correct indexing for nums
	       }
	       
	       // Check for the pivot index
	       for (int i = 0; i < nums.length; i++) {
	           if (pf[i] == sf[i + 1]) { // If prefix sum up to index i equals suffix sum after index i
	               return i;
	           }
	       }
	       return -1;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPivotIndex pvi = new FindPivotIndex();
		int[] a = {1,7,3,6,5,6};
		System.out.println(pvi.pivotIndex(a)); // 3
	}

}
