/*10
5
2
3
1
4
2
3
5
1
7*/
package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumSorting3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			a[i] = x;
		}
		Arrays.sort(a);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			bw.write(a[i]);
		}
		bw.flush();
		bw.close();
	}
}
