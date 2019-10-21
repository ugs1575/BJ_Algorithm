/*나머지가 두자리 수일 때 reverse를 하게 되면 한 숫자인데 역순으로 출력하게 되므로
StringBuilder는 쓰면 안됨*/
package math1;
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
		
		//a진법 -> 10진법
		for(int i=m-1; i>=0; i--) {
			int num = sc.nextInt();
			sum += num * Math.pow(a, i);
		}
		
		convert(sum, b);
	
	}
}
