package DailyCodingChalenge;

class Apr18th {
	int row, col;
	public int islandPerimeter(int[][] grid) {
		row = grid.length;
		col = grid[0].length;
		int result = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == 1){
					result += isWater(i+1, j, grid);
					result += isWater(i-1, j, grid);
					result += isWater(i, j+1, grid);
					result += isWater(i, j-1, grid);
				}
			}
		}

		return result;
	}

	public int isWater(int i, int j, int[][] grid){
		if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return 1;
		if(grid[i][j] == 0) return 1;
		return 0;
	}
}
