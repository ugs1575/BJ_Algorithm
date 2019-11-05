/*primitive type (ex. int) Arrays�� Arrays.sort�� ȣ���ؼ� ��Ʈ�ϸ� �־��� ��� O(n^2)�Դϴ�.
Arrays.sort�� primitive type�� ���� merge sort�� �ƴ� dual-pivot quicksort�� �̷�����ϴ�.

Collections.sort�� ArrayList, LinkedList�� ���� Collection Ÿ���� ������ �����Ѵ�.
�� �Լ��� ���� �˰����� merge sort�̴�.

�������� ����
�������� ������ ���ؼ��� primitive type�� �ƴ϶� Wrapper Ŭ������ �����ؾ� �Ѵ�. �� ������ Collections�� ������ �޾ƾ� �ϱ� �����̴�.
 Collections.reverseOrder()�� �߰� ���ڷ� ������ �ȴ�.
*/

package sort;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class NumSorting2 {
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
