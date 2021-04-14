package dynamicProgramming;
import java.util.*;

public class Bytonic {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] inc = new int[n];
		int[] dec = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		/*//�����ϴ� �κм���
		for(int i=1; i<n; i++) {
			int max = inc[i];
			for(int j=0; j<i; j++) {
				if(a[i]>a[j]) {
					if(max < inc[j]+1) {
						max = inc[j]+1;
						inc[i] = max;
					}
				}
			}
		}*/
		
		//�����ϴ� �κм��� - ���� Ǯ��
		for(int i=0; i<n; i++) {
			inc[i] = 1;
			for(int j=0; j<i; j++) {
				if(a[i]>a[j] && inc[i]<inc[j]+1) {
					inc[i] = inc[j]+1;
				}
			}
		}
		
		/*//�����ϴ� �κм���
		for(int i=n-2; i>=0; i--) {
			int max = dec[i];
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j]) {
					if(max < dec[j]+1) {
						max = dec[j]+1;
						dec[i] = max;
					}
				}
			}
		}*/
		
		//�����ϴ� �κм��� - ���� Ǯ��
		for(int i=n-1; i>=0; i--) {
			dec[i] = 1;
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j] && dec[i] < dec[j]+1) {
					dec[i] = dec[j]+1;
				}
			}
		}
		
		
		int ans = inc[0]+dec[0]-1;
		for(int i=0; i<n; i++) {
			if(ans < inc[i]+dec[i]-1) {
				ans = inc[i]+dec[i]-1;
			}
		}
		

		System.out.println(ans);
		
	}
}
