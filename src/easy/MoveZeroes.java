package easy;

public class MoveZeroes {
	public void moveZeroes(int[] nums) { // my sol
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length - 1; j++) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					// System.out.println(j);
				}
			}
		}
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
    public void slowSolution4(int[] nums) { // Best
        int c = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                moveIt(nums, i, c);
                break;
            }
        }
    }
    public static void moveIt(int[] nums, int i, int c){
        c++;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                moveIt(nums, j, c);
                return;
            }
            nums[j - c] = nums[j];
        }
        for (int k = 1; k < c + 1; k++) {
            nums[nums.length - k] = 0;
        }
    }
	public void moveZeroes1(int[] nums) { // O(N)
		int k = 0; // track 0th position
		for (int i = 0; i <nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[k];
				nums[k] = nums[i];
				nums[i] = temp;
				k++;
			}
		}
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeroes mz = new MoveZeroes();
		int[] A = { 0, 1, 0, 3, 12 };
		int[] B = { 0 };
		int[] C = { 0, 0, 0, 3, 12 };
		int[] D = { 0, 4, 11, 0 };
		int[] E = { 1, 2, 3, 0, 0 };
		mz.moveZeroes(A); // 1 3 12 0 0 
		mz.moveZeroes(B); // 0
		mz.moveZeroes(C); // 3 12 0 0 0 
		mz.moveZeroes(D); // 4 11 0 0 
		mz.moveZeroes(E); // 1 2 3 0 0 
		mz.moveZeroes1(new int[]{0, 1, 0, 3, 12} );
		mz.moveZeroes1(new int[]{0});
		mz.moveZeroes1(new int[]{0, 0, 0, 3, 12});
		mz.moveZeroes1(new int[]{0, 4, 11, 0});
		mz.moveZeroes1(new int[]{1, 2, 3, 0, 0});
	}

}
