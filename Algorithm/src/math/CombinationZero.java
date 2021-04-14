/*����(nCm) 0�� ����
- ���� : n!/m!(n-m)!
- ���丮���� 2�� ������ 5�� ���� ���� �׻� ���� ������, 5�� ������ ������µ�
- ������ ��� �� �� �𸣱� ������, 2�� ������ 5�� ������ ���ÿ� ������� �Ѵ�.*/

package math;
import java.util.*;

public class CombinationZero {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long two = 0, five = 0;
		
		for(long i=2; i<=n; i*=2) {
			two += n/i;
		}
		// n!�� �ش�Ǵ� 2�� ����� ���ϱ�
		for(long i=2; i<=n-m; i*=2) {
			two -= (n-m)/i;
		}
		// (n-m)!�� �ش�Ǵ� 2�� ����� ���ϱ�
		// ������ϱ� ���ش�
		for(long i=2; i<=m; i*=2) {
			two -= m/i;
		}
		// m!�� �ش�Ǵ� 2�� ����� ���ϱ�
		// ������ϱ� ���ش�
		for(long i=5; i<=n; i*=5) {
			five += n/i;
		}
		// n!�� �ش�Ǵ� 5�� ����� ���ϱ�
		for(long i=5; i<=n-m; i*=5) {
			five -= (n-m)/i;
		}
		// (n-m)!�� �ش�Ǵ� 5�� ����� ���ϱ�
		// ������ϱ� ���ش�
		for(long i=5; i<=m; i*=5) {
			five -= m/i;
		}
		// m!�� �ش�Ǵ� 5�� ����� ���ϱ�
		// ������ϱ� ���ش�
		System.out.println(Math.min(two, five));
		
	}
}
