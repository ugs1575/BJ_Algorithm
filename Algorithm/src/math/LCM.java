package math;
import java.util.*;

public class LCM {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int gcd = gcd(a,b);
			int ans = gcd*(a/gcd)*(b/gcd);
			System.out.println(ans);
		}
	}
	
	public static int gcd(int a, int b) {
		int r = a%b;
		if(r==0) {
			return b;
		}else {
			return gcd(b, r);
		}
	}
}
