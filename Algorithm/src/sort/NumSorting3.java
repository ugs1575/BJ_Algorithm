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
/*Counting Sort ���
 * ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. 
 * �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
 * ���� ������ ����� �迭�� ���� �� �ִ°��� Counting Sort�� ����Ѵ�.*/
package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class NumSorting3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num]+=1;
		}
		
		for(int i=1; i<=10000; i++) {
			if(arr[i]>0) {
				for(int j=0; j<arr[i]; j++) {
					bw.write(i+"\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		
	}
	

	
}
