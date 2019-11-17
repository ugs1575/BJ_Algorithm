/*5
10
1
5
2
3*/

package sort;
import java.util.*;

public class BubbleSort { 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		boolean change = false;
		int cnt = 0;
		for(int i=1; i<n; i++) {
			change = false;
			for(int j=1; j<n-i; j++) {
				if(arr[j]>arr[j+1]) {
					change = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			if(change == false) {
				System.out.println(cnt);
				break;
			}else {
				cnt++;
			}
		}
	}
}
