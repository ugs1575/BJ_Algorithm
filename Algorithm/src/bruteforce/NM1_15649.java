package bruteforce;

import java.util.Scanner;

public class NM1_15649 {
	static boolean[] check;
	static int[] ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n+1];
		ans = new int[m];
		
		permute(0, n, m);
		
	}
	
	public static void permute(int index, int n, int m) {
		if(index == m) {
			for(int i=0; i<index; i++) {
				System.out.print(ans[i]+" ");
			}
			
			System.out.println();
		}else {
			for(int i=1; i<=n; i++) {
				if(check[i]) continue;
				ans[index] = i;
				check[i] = true;
				if(index+1 <= m) {
					permute(index+1, n, m);
					check[i] = false;
				}
			}
		}
		
		
	}
	
}
