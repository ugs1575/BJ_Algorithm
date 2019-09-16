package dynamic_programming;
import java.util.*;

public class Tyle3xn {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n+1];
		
		for(int i=2; i<=n; i++) {
			if(i%2==0) {
				d[i] = (d[i-2]+1)*3;
			}
		}
		
		System.out.println(d[n]);
	}
}
