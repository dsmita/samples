package com.debs.sample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ChessKnight {
	 // all valid movements for a knight
	static int[] rows = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] cols = { 1, -1, 1, -1, 2, -2, 2, -2 };

	private static boolean valid(int x, int y, int N) {
		if (x < 0 || x >= N || y < 0 || y >= N - 1)
			return false;
		return true;
	}

	public static int BFS(KnightNode src, KnightNode dest, int N) {
		Map<KnightNode, Boolean> visited = new HashMap<>();

		Queue<KnightNode> q = new LinkedList<KnightNode>();
		q.add(src);

		while (!q.isEmpty()) {
			KnightNode knightNode = q.poll();
			int x = knightNode.x;
			int y = knightNode.y;
			int dist = knightNode.dist;

			// if destination is reached, return distance
			if (x == dest.x && y == dest.y)
				return dist;

			// Skip if location is visited before
			if (visited.get(knightNode) == null) {
				visited.put(knightNode, true);
			}
			
			// check for all 8 possible movements for a knight
			// and enqueue each valid movement into the queue
			for(int i=0;i<8;i++){
				int x1=x+rows[i];
				int y1=y+cols[i];
				if(valid(x,y,8)){
					q.add(new KnightNode(x1, y1));
				}
			}
		}
		// return -1 if path is not possible
		return -1;
	}

}
