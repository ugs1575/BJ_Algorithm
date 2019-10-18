package math1;
import java.util.*;

public class BaseConversion {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		
		//a柳过 -> 10柳过
		for(int i=m-1; i>=0; i--) {
			int num = sc.nextInt();
			sum += num * Math.pow(a, i);
		}
		
		
		//10柳过 -> b柳过
		boolean stop = false;
		StringBuilder sb = new StringBuilder();
		while(!stop) {
			int moc = sum/b;
			int nmg = sum%b;
			sb.append(Integer.toString(nmg));
			if(moc == 0) {
				stop = true;
			}else {
				sum = moc;
			}
		}
		
		sb.reverse();
		
		for(int i=0; i<sb.length(); i++) {
			System.out.print(sb.charAt(i)+" ");
		}
	
	}
}
