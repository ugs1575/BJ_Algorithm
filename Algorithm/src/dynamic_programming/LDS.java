package dynamic_programming;
import java.util.*;

public class LDS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			d[i] = 1;
		}
		
		for(int i=n-2; i>=0; i--) {
			int max = d[i];
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j]) {
					if(max < d[j]+1) {
						max = d[j]+1;
						d[i] = max;
					}
				}
			}
		}
		
		int ans = d[0];
		for(int i=0; i<n; i++) {
			if(ans<d[i]) {
				ans = d[i];
			}
		}
		
		System.out.println(ans);
		
		
	}
}
