package math1;
import java.util.*;

public class Conversion {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int b = sc.nextInt();
		char[] arr = n.toCharArray();
		int square = 0;
		int ans = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(Character.isLetter(arr[i])) {
				int num = (int) arr[i];
				ans += (num-55) * Math.pow(b, square);
			}else {
				int num = Character.getNumericValue(arr[i]);
				ans += num * Math.pow(b, square);
			}
			
			square++;
		}
		
		System.out.println(ans);
	}
}
