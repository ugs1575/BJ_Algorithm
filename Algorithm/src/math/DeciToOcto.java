package math;
import java.util.*;

/*String ��ü�� immutable�ϱ� ������ += �� �� ������ ������ ������ ��� �����ؼ� ���ο� ��ü�� �����, �� �ڿ� ���ڿ��� �̾�ٿ��� �մϴ�. 
������ ��ü�� ���� �������Ƿ� �������� �ϴµ� �̰� �޸𸮿��� ������ �����Ǳ������ �ð��� �ɸ��� ������ ���Դϴ�. ���� �޸� ������ �ذ�ȴٰ� �ϴ��� �ð� �ʰ��� �� ���Դϴ�.
String ��ſ� StringBuilder�� ����ϸ� �� ����˴ϴ�.
*/

public class DeciToOcto {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		StringBuilder str = new StringBuilder();
		int square = 0;
		int sum = 0;
		
		for(int i=n.length()-1; i>=0; i--) {
			if(Character.getNumericValue(n.charAt(i))==1) {
				int num = (int) Math.pow(2, square);
				sum += num;
			}
			square ++;
			if(square == 3 || i == 0) {
				square = 0;
				str.append(Integer.toString(sum));
				sum = 0;
			}
		}
		
		str = str.reverse();
		System.out.print(str);
	}
}
