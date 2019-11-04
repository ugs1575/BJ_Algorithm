package math1;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Sorting {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
		}
		Collections.sort(arr);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			bw.write(arr.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
