/*primitive type (ex. int) Arrays를 Arrays.sort를 호출해서 소트하면 최악의 경우 O(n^2)입니다.
Arrays.sort에 primitive type이 들어가면 merge sort가 아닌 dual-pivot quicksort가 이루어집니다.

Collections.sort는 ArrayList, LinkedList와 같은 Collection 타입의 정렬을 지원한다.
이 함수의 정렬 알고리즘은 merge sort이다.

내림차순 정렬
내림차순 정렬을 위해서는 primitive type이 아니라 Wrapper 클래스로 선언해야 한다. 그 이유는 Collections에 도움을 받아야 하기 때문이다.
 Collections.reverseOrder()을 추가 인자로 넣으면 된다.
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
