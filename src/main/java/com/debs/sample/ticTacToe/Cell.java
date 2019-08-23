package com.debs.sample.ticTacToe;

public class Cell {
	
	private int row;
	private int column;
	private Mark mark;
	
	public Cell(int row, int column){
		this.row=row;
		this.column=column;
		this.mark =Mark.empty;
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
	public Mark getMark() {
		return mark;
	}
	public void setMark(Mark mark) {
		this.mark = mark;
	}

}
