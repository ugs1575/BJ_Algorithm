package bruteforce;

import java.util.*;

public class permutation_10974 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = new int[n];
		boolean[] chk = new boolean[n+1];
		
		permute(n, ans, chk, 0);
	}
	
	public static void permute(int n, int[] ans, boolean[] chk, int index) {
		if(index == n) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				sb.append(ans[i]);
				if(i != n-1) sb.append(" ");
			}
			System.out.println(sb);
		}else {
			for(int i=1; i<=n; i++) {
				if(chk[i]) continue;
				ans[index] = i;
				chk[i] = true;
				permute(n, ans, chk, index+1);
				chk[i] = false;
			}
		}
	}
}
