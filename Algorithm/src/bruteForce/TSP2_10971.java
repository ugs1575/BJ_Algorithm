package bruteforce;

import java.util.*;

public class TSP2_10971 {
	static int cityCnt, min = 10000000;
	static int[] ans;
	static int[][] cost;
	static boolean[] check;
	static ArrayList<Integer>[] aList;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		cityCnt = sc.nextInt();
		aList = new ArrayList[cityCnt+1];
		cost = new int[cityCnt+1][cityCnt+1];
		ans = new int[cityCnt];
		check = new boolean[cityCnt+1];
		
		for(int i=0; i<=cityCnt; i++) {
			aList[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=cityCnt; i++) {
			for(int j=1; j<=cityCnt; j++) {
				cost[i][j] = sc.nextInt();
				if(cost[i][j] != 0)
					aList[i].add(j);
				
			}
		}

		ans[0] = 1;
		check[1] = true;
		permutation(1, 1);
		
		System.out.println(min);
	}
	
	public static void permutation(int start, int index) {
		if(index == cityCnt){
			int sum = 0;
			for(int i=0; i<cityCnt-1; i++){
				//System.out.print(ans[i]+"  ");
				sum += cost[ans[i]][ans[i+1]];
			}
			//System.out.print(ans[cityCnt-1]);
			//System.out.println();

			boolean goBack = false;
			for(int i=0; i<aList[ans[cityCnt-1]].size(); i++){
				if(aList[ans[cityCnt-1]].get(i) == ans[0]){
					sum += cost[ans[cityCnt-1]][ans[0]];
					goBack = true;
				}
			}

			if(goBack && sum < min){
				min = sum;
			}

		}else{
			for(int i=0; i<aList[start].size(); i++){
				int nextCity = aList[start].get(i);
				if(check[nextCity]) continue;
				ans[index] = nextCity;
				check[nextCity] = true;
				permutation(nextCity,index+1);
				check[nextCity] = false;
			}
		}
	}
}