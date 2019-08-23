package com.debs.sample.nQueen;

public class NQueenProblem {
	
	public void addQueens(int n){
		Board board = new Board(n,n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board.addQueen(i, j);
			}
		}
	}

}
