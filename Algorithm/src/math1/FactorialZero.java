/*팩토리얼 0의 개수
- 10!의 0이 2개인 이유는 10!을 소인수분해 해보면 알 수 있다.
- 10! = 2^8 x 3^4 x 5^2 x 7
- 2x5의 조합이 두번 들어가 있어서 0의 개수는 2개
- N!의 0이 몇 개인지 알아내려면 N!을 소인수분해 했을 때, 2와 5가 몇개 나오는지 알아야 한다.
- 5의 개수가 항상 2의 개수 보다 적기 때문에, 5의 개수만 세어주면 된다.
- N! 0의 개수 = [N/5] + [N/5^2] + [N/5^3] + ...
*/

package math1;
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
