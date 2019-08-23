package com.debs.sample.ticTacToe;

public class Board {

	private Cell[][] cells;
	int totalRows;
	int totalColumns;

	public Board(int totalRows, int totalColumns) {
		this.totalRows = totalRows;
		this.totalColumns = totalColumns;

		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}

	public boolean hasWon() {
		if (hasWonRow() || hasWonColumn() || hasWonDiagonal())
			return true;
		return false;
	}

	private boolean hasWonDiagonal() {
		for (int i = 0; i < totalRows - 1; i++) {
			for (int j = 0; j < totalColumns - 1; j++) {
				if (!cells[i][j].getMark().equals(Mark.empty) && cells[i + 1][j + 1].equals(cells[i][j])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasWonColumn() {
		for (int i = 0; i < totalRows - 1; i++) {
			for (int j = 0; j < totalColumns - 1; j++) {
				if (!cells[i][j].getMark().equals(Mark.empty) && cells[i + 1][j].equals(cells[i][j])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasWonRow() {
		for (int i = 0; i < totalRows - 1; i++) {
			for (int j = 0; j < totalColumns - 1; j++) {
				if (!cells[i][j].getMark().equals(Mark.empty) && cells[i][j].equals(cells[i][j + 1])) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean placeMark(int row, int col, Mark mark) {
		if ((row >= 0) && (row < 3)) {
			if ((col >= 0) && (col < 3)) {
				if (cells[row][col].equals(Mark.empty)) {
					cells[row][col].setMark(mark);
					return true;
				}
			}
		}
		return false;
	}

}
