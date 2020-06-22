package bruteForce;

import java.util.*;

public class TSP2_10971 {
	static int city, min;
	static int[] ans;
	static int[][] cost;
	static boolean[] check;
	static ArrayList<Integer>[] aList;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		city = sc.nextInt();
		aList = new ArrayList[city+1];
		cost = new int[city+1][city+1];
		ans = new int[city];
		check = new boolean[city+1];
		
		for(int i=0; i<=city; i++) {
			aList[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=city; i++) {
			for(int j=1; j<=city; j++) {
				cost[i][j] = sc.nextInt();
				if(cost[i][j] != 0)
					aList[i].add(j);
				
			}
		}
		
		for(int i=1; i<=city; i++) {
			BFS(i, i, 0);
		}
		
		System.out.println(min);
	}
	
	public static void BFS(int n, int start, int index) {
		
		if(index == city) {
			int sum = 0;
			for(int i=0; i<city; i++) {
				sum += ans[i];
			}
			if(sum < min) {
				min = sum;
			}
			
			return;
		}
		
		for(int i=0; i<aList[n].size(); i++) {
			int nextCity = aList[n].get(i);
			if(!check[nextCity] && nextCity != start) {
				ans[index] = cost[n][nextCity];
				System.out.println(n+"/"+nextCity+"/"+index);
				check[nextCity] = true;
				BFS(nextCity, start, index+1);
				check[nextCity] = false;
			}
		}
	}
}
