/*5
10
1
5
2
3*/

package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BubbleSort { 
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
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
				bw.write(cnt+"\n");
				break;
			}else {
				cnt++;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
