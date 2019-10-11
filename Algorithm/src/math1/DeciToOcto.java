package math1;
import java.util.*;

public class DeciToOcto {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String str = "";
		int square = 0;
		int sum = 0;
		
		for(int i=n.length()-1; i>=0; i--) {
			int num = Character.getNumericValue(n.charAt(i)) * (int) Math.pow(2, square);
			sum += num;
			square ++;
			if((i+1)%3==0 || i==0) {
				square = 0;
				str += Integer.toString(sum);
				sum = 0;
			}
		}
		
		for(int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
	}
}
