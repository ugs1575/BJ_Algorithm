/*소인수분해
- 정수   n을 소수의 곱으로 분해
- 소수를 구하지 않고도 해결할 수 있다.
- n을 소인수분해 했을 때, 나타날 수 있는 인수 중에서 가장 큰 값은 루트 n이다.
- 따라서, 2부터 루트n까지 for문을 돌면서
- n을 나눌수 있으면, 나눌 수 없을 때까지 계속해서 나누면 된다.*/

package math1;
import java.util.*;

public class PrimeFactorization {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=2; i*i<=n; i++) {
			while(n%i==0) {
				System.out.println(i);
				n/=i;
			}
		}
		
		if(n>1) {
			System.out.println(n);
		}
	}
}
