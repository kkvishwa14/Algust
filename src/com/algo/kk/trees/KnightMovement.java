package com.algo.kk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMovement {

	int X_Moves[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
    int Y_Moves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	boolean visited[][];
    public boolean isSafeMove(int A, int B, int X, int Y) {
    	if (X > 0 && Y > 0 && X < A && Y < B)
    		return true;
    	return false;
    }
    class Point {
    	int x;
    	int y;
    	public Point(int a,int b) {
    		this.x= a;
    		this.y = b;
    	}
    }
    
    public int[] getLocation(String location ){
    	String[] parts = location.split("-");
    	int[] point = new int[2];
    	point[0] = Integer.parseInt(parts[0]);
    	point[1] = Integer.parseInt(parts[1]);
    	return point;
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
    	A +=1;
    	B +=1;
    	if(!isSafeMove(A, B, C, D) || !isSafeMove(A, B, E, F)){
    		return -1;
    	}
    	visited = new boolean[A-1][B-1];
    	for(int i=0;i<A-1;i++) {
    		for(int j=0;j<B-1;j++){
    			visited[i][j]= false;
    		}
    	}
    	Queue<Point> bfsQueue = new LinkedList<Point>();
    	bfsQueue.add(new Point(C, D));
    	int minMoves = 0;
    	while(!bfsQueue.isEmpty()) {
    		int levelCount = bfsQueue.size();
    		for(int i=0;i<levelCount;i++) {
    			
    			Point point = bfsQueue.remove();
    			if(point.x==E && point.y==F){
    				return minMoves;
    			}
    			
    			for(int move=0;move<8;move++) {
    				int newX = point.x + X_Moves[move];
    				int newY = point.y + Y_Moves[move];
    				if(isSafeMove(A, B, newX, newY) && !visited[newX-1][newY-1]) {
    					bfsQueue.add(new Point(newX, newY));
    				}
    			}
    			visited[point.x-1][point.y-1] = true;
    		}
    		minMoves++;
    	}
    	
    	return -1;
    }
	
    
	public static void main(String[] args) {
		
		KnightMovement km = new KnightMovement();
		System.out.println(km.knight(2, 20, 1, 18, 1, 5));
	}

}
