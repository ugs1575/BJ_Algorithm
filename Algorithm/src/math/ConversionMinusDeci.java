package math;
import java.util.*;

public class ConversionMinusDeci {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean stop = false;
		
		while(!stop) {
			int moc = n/(-2);
			int nmg = n%(-2);
			if(n<0 && nmg !=0) {
				moc ++;
				nmg = n-((-2)*moc);
			}
			sb.append(Integer.toString(nmg));
			n = moc;
			if(n==0) {
				stop = true;
			}
			
		}
		
		sb.reverse();
		System.out.print(sb);
	}
}
