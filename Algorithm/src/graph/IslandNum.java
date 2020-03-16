package graph;

import java.util.*;

public class IslandNum {
	static int x = 1;
	static int y = 1;
	static int[][] map;
	static int[][] check;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		y = sc.nextInt();
		x = sc.nextInt();
		
		while(x!=0 && y!=0) {
			map    = new int[x][y];
			check  = new int[x][y];
			
			for(int r=0; r<x; r++) {
				for(int c=0; c<y; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int islandNum = 0;
			for(int r=0; r<x; r++) {
				for(int c=0; c<y; c++) {
					//¶¥ÀÌ°í ¹æ¹® ¾ÈÇß´Ù¸é
					if(map[r][c] == 1 && check[r][c] == 0) {
						bfs(r,c);
						islandNum++;
					}
				}
			}
			
			System.out.println(islandNum);
			
			y = sc.nextInt();
			x = sc.nextInt();
		}
		
	}
	
	public static void bfs(int r, int c) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		check[r][c] = 1;
		qx.add(r);
		qy.add(c);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			r = qx.peek();
			c = qy.peek();
			
			//»ó
			if(r-1 >= 0) {
				if(map[r-1][c] == 1 && check[r-1][c] == 0) {
					check[r-1][c] = 1;
					qx.add(r-1);
					qy.add(c);
				}
			}
			
			//ÇÏ
			if(r+1 < x) {
				if(map[r+1][c] == 1 && check[r+1][c] == 0) {
					check[r+1][c] = 1;
					qx.add(r+1);
					qy.add(c);
				}
			}
			
			//ÁÂ
			if(c-1 >= 0) {
				if(map[r][c-1] == 1 && check[r][c-1] == 0) {
					check[r][c-1] = 1;
					qx.add(r);
					qy.add(c-1);
				}
			}
		
			//¿ì
			if(c+1 < y) {
				if(map[r][c+1] == 1 && check[r][c+1] == 0) {
					check[r][c+1] = 1;
					qx.add(r);
					qy.add(c+1);
				}
			}
			
			//»óÁÂ
			if(r-1 >= 0 && c-1 >= 0) {
				if(map[r-1][c-1] == 1 && check[r-1][c-1] == 0) {
					check[r-1][c-1] = 1;
					qx.add(r-1);
					qy.add(c-1);
				}
			}
			
			//»ó¿ì
			if(r-1 >= 0 && c+1 < y) {
				if(map[r-1][c+1] == 1 && check[r-1][c+1] == 0) {
					check[r-1][c+1] = 1;
					qx.add(r-1);
					qy.add(c+1);
				}
			}
			
			//ÇÏÁÂ
			if(r+1 < x && c-1 >= 0) {
				if(map[r+1][c-1] == 1 && check[r+1][c-1] == 0) {
					check[r+1][c-1] = 1;
					qx.add(r+1);
					qy.add(c-1);
				}
			}
			
			//ÇÏ¿ì
			if(r+1 < x && c+1 < y) {
				if(map[r+1][c+1] == 1 && check[r+1][c+1] == 0) {
					check[r+1][c+1] = 1;
					qx.add(r+1);
					qy.add(c+1);
				}
			}
			
			qx.remove();
			qy.remove();
		}
		
	}
	
	
}
