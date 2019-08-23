package com.debs.sample;

public class KnightNode {
	
	int x;
	int y;
	int dist;
	
	public KnightNode(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public KnightNode(int x, int y, int dist){
		this.x=x;
		this.y=y;
		this.dist=dist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dist;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KnightNode other = (KnightNode) obj;
		if (dist != other.dist)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
