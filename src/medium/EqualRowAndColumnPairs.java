package medium;

import java.util.HashMap;

public class EqualRowAndColumnPairs {
// https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
	
    public int equalPairs(int[][] grid) {
    	int n = grid.length;
        int count = 0;
        
        // Iterate through all rows
        for (int i = 0; i < n; i++) {
            // Iterate through all columns
            for (int j = 0; j < n; j++) {
                boolean equal = true;
                // Compare row i and column j
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    count++;
                }
            }
        }
        
        return count;
    }
    int n;
    public int equalPairsBest(int[][] grid) {
        n = grid.length;
        int ans=0;
        HashMap <Integer, Integer> row = new HashMap<>();
        for(int i=0; i<n; i++){
            int hashKey = rowHashCode(grid[i]);
            row.put(hashKey, row.getOrDefault(hashKey, 0)+1);
        }

        for(int i=0; i<n; i++){
            int hashKey = colHashCode(grid, i);
            ans+=row.getOrDefault(hashKey, 0);
        }
        return ans;
    }

    public int rowHashCode(int [] row){
        int result =0;

        for(int num : row){
            result = num + result * 5;
        }

        return result;
    }

    public int colHashCode(int [][] grid, int col){
        int result =0;
        for(int i=0; i<n; i++){
            result = grid[i][col] + result *5;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EqualRowAndColumnPairs ec = new EqualRowAndColumnPairs();
		int[][] grid = {{3,2,1}, {1,7,6}, {2,7,7}};
		System.out.println(ec.equalPairs(grid)); // 1
		int[][] a = {{3,1,2,2},{1,4,4,5}, {2,4,2,2}, {2,4,2,2}};
		System.out.println(ec.equalPairs(a)); // 3
		/*
		 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
		 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
		 */
	}

}
