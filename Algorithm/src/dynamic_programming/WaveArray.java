package dynamic_programming;
import java.util.*;

public class WaveArray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] d = new long[101];
		d[1] = 1;
		d[2] = 1;
		d[3] = 1;
		d[4] = 2;
		d[5] = 2;
		
		for(int i=6; i<=100; i++) {
			d[i] = d[i-1] + d[i-5];
		}
		
		for(int i=0; i<t; i++) {
			int num = sc.nextInt();
			System.out.println(d[num]);
		}
		
		
	}
}
