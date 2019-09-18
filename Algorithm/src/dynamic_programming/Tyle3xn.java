package dynamic_programming;
import java.util.*;

public class Tyle3xn {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n+1];
		
		d[0] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=i; j++) {
				if(j%2==0) {
					if(j==2) {
						d[i] += d[i-j]*3;
					}else {
						d[i] += d[i-j]*2;
					}
				
				}	
			}
		}

		System.out.println(d[n]);
	}
}
