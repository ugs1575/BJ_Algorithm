/*���丮�� 0�� ����
- 10!�� 0�� 2���� ������ 10!�� ���μ����� �غ��� �� �� �ִ�.
- 10! = 2^8 x 3^4 x 5^2 x 7
- 2x5�� ������ �ι� �� �־ 0�� ������ 2��
- N!�� 0�� �� ������ �˾Ƴ����� N!�� ���μ����� ���� ��, 2�� 5�� � �������� �˾ƾ� �Ѵ�.
- 5�� ������ �׻� 2�� ���� ���� ���� ������, 5�� ������ �����ָ� �ȴ�.
- N! 0�� ���� = [N/5] + [N/5^2] + [N/5^3] + ...
*/

package math;
import java.util.*;

public class FactorialZero {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=5; i<=n; i*=5) {
			sum+=n/i;
		}
		
		System.out.println(sum);
	}
}
