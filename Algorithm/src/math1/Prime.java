package math1;
import java.util.*;

public class Prime {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean prime = false;
		
		for(int i=m; i<=n; i++) {
			prime = prime(i);
			
			if(prime) {
				System.out.println(i);
			}
		}
		
		
	}
	
	public static boolean prime(int x) {
		boolean prime = true;
		
		if(x==1) {
			prime = false;
		}else {
			for(int i=2; i*i<=x; i++) {
				if(x%i==0) {
					prime = false;
				}
			}
		}
		
		return prime;
	}
}
