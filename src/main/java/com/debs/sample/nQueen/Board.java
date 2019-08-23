package com.debs.sample.nQueen;


public class Board {
	
	private Cell[][] cells;
	int totalRows;
	int totalColumns;
	
	public Board(int totalRows, int totalColumns){
		this.totalRows = totalRows;
		this.totalColumns = totalColumns;
		
		for(int i=0;i<totalRows;i++){
			for(int j=0;j<totalColumns;j++){
				cells[i][j] = new Cell(i,j);
			}
		}
	}
	
	public boolean addQueen(int row, int column){
		if(isRowSafe(row) && isColumnSafe(column) && isDiagonalSafe(row, column)){
			cells[row][column].setOccupied(true);
			return true;
		}
		return false;
	}
	
	public boolean isRowSafe(int row){
		for(int i=0;i<totalColumns;i++){
			if(cells[row][i].isOccupied())
				return false;
		}
		return true;
	}
	
	public boolean isColumnSafe(int column){
		for(int i=0;i<totalRows;i++){
			if(cells[i][column].isOccupied())
				return false;
		}
		return true;
	}

	public boolean isDiagonalSafe(int row, int column) {
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				if (Math.abs(row - i) == Math.abs(column - j)) {
					if (cells[i][j].isOccupied())
						return false;
				}
			}

		}
		return true;
	}

}
