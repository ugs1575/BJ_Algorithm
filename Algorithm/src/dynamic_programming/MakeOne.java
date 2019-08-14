package dynamic_programming;
import java.util.*;
//1463 1로만들기
//Top-Down 방식


public class MakeOne {
	public static int[] d;
	public static int makeOne(int n) {
		if (n == 1) return 0;
		
		if(d[n] > 0) return d[n];
		
		d[n] = makeOne(n-1) + 1;
		
		if(n%2 == 0) {
			int temp = makeOne(n/2) + 1;
			if(d[n] > temp) d[n] = temp;
		}
		
		if(n%3 == 0) {
			int temp = makeOne(n/3) +1;
			if(d[n] > temp) d[n] = temp;
		}
		
		return d[n];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		System.out.println(makeOne(n));
	}
}
