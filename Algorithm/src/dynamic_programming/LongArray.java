package dynamic_programming;
import java.util.*;

public class LongArray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=i+1; j<n; j++) {
				if(a[j]>a[i]) {
					cnt++;
				}
			}
			if(cnt!=n && ans<cnt) {
				ans = cnt;
			}
		}
		
		System.out.print(ans);
	}
}
