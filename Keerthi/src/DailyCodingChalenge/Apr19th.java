package DailyCodingChalenge;

class Apr19th {
	public int numIslands(char[][] grid) {
		int islands = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == '1'){
					islands++;
					markAsVisited(i, j, grid);
				}
			}
		}

		return islands;
	}

	public void markAsVisited(int i, int j, char[][] grid){
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
		if(grid[i][j] == '0') return;
		grid[i][j] = '0';
		markAsVisited(i+1, j, grid);
		markAsVisited(i-1, j, grid);
		markAsVisited(i, j+1, grid);
		markAsVisited(i, j-1, grid);

	}
}
