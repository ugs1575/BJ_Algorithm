package math1;
import java.util.*;

/*String 객체는 immutable하기 때문에 += 을 할 때마다 기존의 내용을 모두 복사해서 새로운 객체를 만들고, 그 뒤에 문자열을 이어붙여야 합니다. 
기존의 객체는 쓸모가 없어지므로 버려져야 하는데 이게 메모리에서 실제로 해제되기까지는 시간이 걸리는 것으로 보입니다. 설령 메모리 문제가 해결된다고 하더라도 시간 초과가 뜰 것입니다.
String 대신에 StringBuilder를 사용하면 잘 통과됩니다.
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
