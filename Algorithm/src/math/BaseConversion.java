/*�������� ���ڸ� ���� �� reverse�� �ϰ� �Ǹ� �� �����ε� �������� ����ϰ� �ǹǷ�
StringBuilder�� ���� �ȵ�*/
package math;
import java.util.*;

public class BaseConversion {
	public static void convert(int num, int base) {
        if (num == 0) {
            return;
        }

        convert(num/base, base);
        System.out.print(num%base + " ");

    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		
		//a���� -> 10����
		for(int i=m-1; i>=0; i--) {
			int num = sc.nextInt();
			sum += num * Math.pow(a, i);
		}
		
		convert(sum, b);
	
	}
}
