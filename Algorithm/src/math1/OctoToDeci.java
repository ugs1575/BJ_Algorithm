package math1;
import java.util.*;

public class OctoToDeci {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		StringBuilder ans = new StringBuilder();
		String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
		
		for(int i=0; i<n.length(); i++) {
			int num = Character.getNumericValue(n.charAt(i));
			String str = arr[num];
			ans.append(str);
		}
		
		int compare = Character.compare(ans.charAt(0), '0');
		if(compare == 0 && n.length()!=1) {
			ans.delete(0,1);
		}else if(ans.equals("0") || ans.equals("1")) {
			ans.delete(0,2);
			System.out.print("hi");
		}
		
		System.out.print(ans);
	}
}
