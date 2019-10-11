package math1;
import java.util.*;

public class OctoToDeci {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String str = "";
		String ans = "";
		String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
		
		for(int i=0; i<n.length(); i++) {
			int num = Character.getNumericValue(n.charAt(i));
			str += arr[num];
		}
		
		int compare = Character.compare(str.charAt(0), '0');
		if(compare == 0) {
			ans = str.substring(1);
		}
		
		System.out.print(ans);
	}
}
