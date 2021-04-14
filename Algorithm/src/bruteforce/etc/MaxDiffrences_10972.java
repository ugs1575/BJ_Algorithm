package bruteforce.etc;

import java.util.*;

public class MaxDiffrences_10972 {
	static int max = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] data = new int[n];
		int[] ans = new int[n];
		boolean[] chk = new boolean[n];
		
		for(int i=0; i<n; i++) {
			data[i] = sc.nextInt();
		}
		
		permutation(n, data, ans, chk, 0);
		
		System.out.println(max);
		
	}
	
	public static void permutation(int n, int[] data, int[] ans, boolean[] chk, int index) {
		if(index == n) {
			int total = 0;
			for(int i=0; i<n-1; i++) {
				int sum = Math.abs(ans[i]-ans[i+1]);
				total += sum;
			}
			
			if(total > max) {
				max = total;
			}
		}else {
			for(int i=0; i<n; i++) {
				if(chk[i]) continue;
				ans[index] = data[i];
				chk[i] = true;
				permutation(n, data, ans, chk, index+1);
				chk[i] = false;
			}
		}
	}
}
