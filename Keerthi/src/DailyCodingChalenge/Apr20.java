package DailyCodingChalenge;

import java.util.ArrayList;

class Apr20 {
	public int[][] findFarmland(int[][] land) {
		ArrayList<int[]> result = new ArrayList<>();
		int row = land.length, col = land[0].length;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(land[i][j] == 1){
					int lastRow = i, lastCol = j;
					while(lastRow < row && land[lastRow][j] == 1){
						lastRow++;
					}

					while(lastCol < col && land[i][lastCol] == 1){
						lastCol++;
					}

					for(int p=i; p<lastRow; p++){
						for(int k=j; k<lastCol; k++){
							land[p][k] = 0;
						}
					}

					result.add(new int[]{i, j, lastRow-1, lastCol-1});
				}
			}
		}

		int[][] formattedResult = new int[result.size()][4];
		int i=0;
		for(int[] n : result) formattedResult[i++] = n;

		return formattedResult;
	}
}
