package dynamic_programming;
import java.util.*;
//1463 1로만들기
//Bottom-Up 방식


public class MakeOne2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n+1];
		
		d[1] = 0;
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0 && d[i] > d[i/2] + 1) {
				d[i] = d[i/2] + 1;
			}
			if(i%3 == 0 && d[i] > d[i/3] + 1) {
				d[i] = d[i/3] + 1;
			}
		}
		
		
	}
}
