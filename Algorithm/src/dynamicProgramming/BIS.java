package dynamicProgramming;
import java.util.*;

public class BIS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		d[0] = a[0];
		
		for(int i=1; i<n; i++) {
			int sum = 0;
			int max = 0;
			for(int j=0; j<i; j++) {
				if(a[j]<a[i]) {
					sum = a[i] + d[j];
				}
				
				if(sum>max) {
					max = sum;
				}
			}
			
			d[i] = max;
		}
		
		int ans = d[0];
		for(int i=0; i<n; i++) {
			if(d[i]>ans) {
				ans = d[i];
			}
			
		}
		
		System.out.println(ans);
	}
}
