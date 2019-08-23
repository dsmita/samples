package com.debs.sample;

public class CustomGraph1 {
	
	private boolean adjancencyMatrix[][];
	private int vertexCount;
	
	public CustomGraph1(int vertexCount){
		this.vertexCount = vertexCount;
		adjancencyMatrix = new boolean[vertexCount][vertexCount];
	}
	
	public void addEdge(int i, int j){
		if(i >= 0 && i < vertexCount && j>0 && j < vertexCount){
			adjancencyMatrix[i][j] = true;
			adjancencyMatrix[j][i] = true;
		}
	}
	
	public void removeEdge(int i, int j){
		if(i >=0 && i < vertexCount && j>0 && j < vertexCount){
			adjancencyMatrix[i][j] = false;
			adjancencyMatrix[j][i] = false;
		}
	}
	
	public boolean isEdge(int i, int j){
		if(i >=0 && i < vertexCount && j>0 && j< vertexCount){
			return adjancencyMatrix[i][j];
		} else
			return false;
	}

}
