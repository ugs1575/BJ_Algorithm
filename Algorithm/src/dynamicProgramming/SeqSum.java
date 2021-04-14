package dynamicProgramming;
import java.util.*;

public class SeqSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			d[i] = a[i];
		}
		
		for(int i=1; i<n; i++) {
			if(d[i-1]+a[i]>d[i]) {
				d[i] = d[i-1]+a[i];
			}
		}
		
		int ans = d[0];
		for(int i=0; i<n; i++){
			if(d[i]>ans) {
				ans = d[i];
			}
		}
		
		System.out.println(ans);
	}
}
