package math1;
import java.util.*;

public class Sosu {
	public static void main(String args[]) {
		int[] arr = new int[10001];
		for(int i=1; i<=1000; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<=1000; i++) {
			for(int j=i+1; j<=1000; j++) {
				if(arr[j]%i==0) {
					arr[j] = 0;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			for(int j=2; j<=1000; j++) {
				if(x==arr[j]) {
					cnt++;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
