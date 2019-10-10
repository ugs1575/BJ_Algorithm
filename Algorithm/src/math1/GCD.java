package math1;
import java.util.*;

public class GCD {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = gcd(a,b);
		int ans2 = ans*(a/ans)*(b/ans);
		
		System.out.println(ans);
		System.out.println(ans2);
	}
	
	public static int gcd(int a, int b) {
		int r = a%b;
		if(r==0) {
			return b;
		}else {
			return gcd(b,r);
		}
	}
}
