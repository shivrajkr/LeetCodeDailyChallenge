package DailyCodingChalenge;

import java.util.Arrays;

class Apr26 {
	int row, col;
	int result = Integer.MAX_VALUE;
	public int minFallingPathSum(int[][] grid) {
		row = grid.length;
		col = grid[0].length;
		int dp[][] = new int[row][col];
		for(int i=0; i<row; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
		for(int j=0; j<col; j++){
			result = Math.min(result, dfs(grid, 0, j, dp));
		}
		return result;
	}

	// dfs with memorisation
	public int dfs(int[][] matrix ,int i ,int j , int[][] dp){
		if(j < 0 || j >= col) return Integer.MAX_VALUE;
		if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
		if(i == row-1){
			return matrix[i][j];
		}

		int minPath = Integer.MAX_VALUE;
		for(int k=0; k<col; k++){
			if(k != j)
				minPath = Math.min(minPath, dfs(matrix, i+1, k, dp));
		}
		minPath += matrix[i][j];
		dp[i][j] = minPath;
		return minPath;
	}
}
