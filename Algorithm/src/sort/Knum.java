/*5 2
4 1 2 3 5*/
package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Knum {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String[] num1 = str1.split(" ");
		String str2 = br.readLine();
		String[] num2 = str2.split(" ");
		
		int n = Integer.parseInt(num1[0]);
		int k = Integer.parseInt(num1[1]);
		long[] arr = new long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(num2[i]);
		}
		
		Arrays.sort(arr);
		
		bw.write(String.valueOf(arr[k-1]));
		bw.flush();
		bw.close();
	}
}
