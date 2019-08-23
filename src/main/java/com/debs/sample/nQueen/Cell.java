package com.debs.sample.nQueen;

public class Cell {

	private int row;
	private int column;
	private boolean isOccupied;
	
	public Cell(int row, int column){
		this.row=row;
		this.column=column;
		this.isOccupied = false;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	
}
