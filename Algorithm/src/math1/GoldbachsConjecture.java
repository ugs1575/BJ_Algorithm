/*
 * 골드바흐의 추측
2보다 큰 모든 짝수는 두소수의 합으로 표현가능하다
위의 문장에 +3을 하면
=> 5보다 큰 모든 홀수는 세소수의 합으로 표현 가능하다
로 바뀐다
아직 증명되지 않은 문제
10^18이하에서는 참인것이 증명되어있다

홀수인지 판별 할 필요가 없는 이유 : 소수이면서 짝수인 수는 2밖에 없다.
증명되지 않았을 때를 처리 할 필요가 없는이유 : 10^18이하에서는 참인것이 증명되어있다.*/

package math1;
import java.util.*;

public class GoldbachsConjecture {
	public static final int MAX = 1000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> prime = new ArrayList<>();
		boolean[] isPrime = new boolean[MAX+1];
		
		isPrime[0] = isPrime[1] = true;
		
		for(int i=2; i*i<=MAX; i++) {
			if(isPrime[i] == false) {
				prime.add(i);
				for(int j = i*i; j<=MAX; j+=i) {
					isPrime[j] = true;
				}
			}else {
				continue;
			}
		}
		
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			for(int i=0; i<prime.size(); i++) {
				int p = prime.get(i);
				if(isPrime[n-p] == false) {
					System.out.println(n+" = "+p+" + "+(n-p));
					break;
				}
			}
			
		}
	}
}
