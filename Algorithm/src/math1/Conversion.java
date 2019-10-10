package math1;
import java.util.Scanner;

public class Conversion {
	public static String str = "";
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		String ans = conversion(n,b);
		
		char[] ans_arr = ans.toCharArray();
		for(int i=ans_arr.length-1; i>=0; i--) {
			System.out.print(ans_arr[i]);
		}
	}
	
	public static String conversion(int n, int b) {
		int moc = n/b;
		int nmg = n%b;
		if(n==0) {
			return str; 
		}else {
			if(nmg<10) {
				str += Integer.toString(nmg);
			}else {
				str += Character.toString((char)(nmg+55));
			}
			return conversion(moc, b);
		}
	}
}
