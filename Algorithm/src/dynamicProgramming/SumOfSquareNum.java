package dynamicProgramming;
import java.util.*;

public class SumOfSquareNum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		
		d[1] = 1;
		for(int i=2; i<=n; i++) {
			d[i] = i;
			for(int j=1; j*j<=i; j++) {
				 if(d[i] > d[i-j*j]+1) {
					 d[i] = d[i-j*j]+1;
				 }
			
			}
		}
		
		
		
		System.out.print(d[n]);
		
		
	}
}
