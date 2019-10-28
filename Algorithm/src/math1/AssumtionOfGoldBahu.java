package math1;
import java.util.*;

public class AssumtionOfGoldBahu {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> prime = new ArrayList<>();
		boolean[] isPrime = new boolean[1000001];
		
		isPrime[0] = isPrime[1] = true;
		
		for(int i=2; i<=1000000; i++) {
			if(isPrime[i] == false) {
				prime.add(i);
				for(int j = i*i; j<=1000000; j+=i) {
					isPrime[j] = true;
				}
			}
		}
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			for(int i=0; i<prime.size(); i++) {
				int tmp = n - prime.get(i);
				
				if(tmp%2==0) {
					continue;
				}else {
					boolean p = prime.contains(tmp);
					if(p) {
						int a2 = prime.get(i);
						int b2 = tmp;
						int c2 = b-a;
						if(c2>c) {
							a = a2;
							b = b2; 
							c= c2;
						}
					}
				}
			}
			
			System.out.println(n+" = "+a+" + "+b);
		}
	}
}
