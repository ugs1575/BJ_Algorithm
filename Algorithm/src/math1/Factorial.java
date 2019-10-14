package math1;
import java.util.*;

public class Factorial {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = fac(n);
		System.out.print(ans);
	}
	
	public static int fac(int n) {
		if(n==1) {
			return 1;
		}
		return n*fac(n-1);
	}
}
