package dynamic_programming;
import java.util.*;

public class EasyStair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long mod = 1000000000L;
		long[] d = new long[n+1];
		long[][] d2 = new long[n+1][10];
		
		d[1] = 9;
		for(int i=1; i<=9; i++) {
			d2[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j-1<0) {
					d2[i][j] = d2[i-1][j+1];
				}else if(j+1>9) {
					d2[i][j] = d2[i-1][j-1];
				}else {
					d2[i][j] = d2[i-1][j+1] + d2[i-1][j-1];
				}
				
				//정답이 int 범위를 넘어갈 수 있기 때문
				d2[i][j] %= mod;
				d[i] += d2[i][j];
			}
			
		}
		
		long ans = d[n] % mod;
		System.out.print(ans);

	}

}
