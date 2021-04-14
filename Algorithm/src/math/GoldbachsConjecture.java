/*
 * �������� ����
2���� ū ��� ¦���� �μҼ��� ������ ǥ�������ϴ�
���� ���忡 +3�� �ϸ�
=> 5���� ū ��� Ȧ���� ���Ҽ��� ������ ǥ�� �����ϴ�
�� �ٲ��
���� ������� ���� ����
10^18���Ͽ����� ���ΰ��� ����Ǿ��ִ�

Ȧ������ �Ǻ� �� �ʿ䰡 ���� ���� : �Ҽ��̸鼭 ¦���� ���� 2�ۿ� ����.
������� �ʾ��� ���� ó�� �� �ʿ䰡 �������� : 10^18���Ͽ����� ���ΰ��� ����Ǿ��ִ�.*/

package math;
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
