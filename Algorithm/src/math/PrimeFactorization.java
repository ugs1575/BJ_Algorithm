/*���μ�����
- ����   n�� �Ҽ��� ������ ����
- �Ҽ��� ������ �ʰ� �ذ��� �� �ִ�.
- n�� ���μ����� ���� ��, ��Ÿ�� �� �ִ� �μ� �߿��� ���� ū ���� ��Ʈ n�̴�.
- ����, 2���� ��Ʈn���� for���� ���鼭
- n�� ������ ������, ���� �� ���� ������ ����ؼ� ������ �ȴ�.*/

package math;
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
