package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Card {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0; i<n; i++) {
			long num = sc.nextLong();
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		
		int cnt = 1;
		int cnt_max = 0;
		long ans = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i-1] == arr[i]) {
				cnt++;
			}else if(arr[i-1] != arr[i]) {
				cnt = 1;
			}
			
			if(cnt_max < cnt) {
				cnt_max = cnt;
				ans = arr[i-1];
			}
		}
		
		System.out.println(ans);
	}
}

