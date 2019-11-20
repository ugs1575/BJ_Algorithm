/*�ι�° �׸��� �ѹ� ������ ��ģ ���Դϴ�.
 * ���⼭ Ȯ���� �� �� �ִ� �Ѱ��� ������ �ֽ��ϴ�.
 * pivot�� ���� 4��° ��ġ��� ���Դϴ�.
 * ���� ������ ���� ��, 4��° ��ġ�� ���ڸ� ����϶� ���ٸ�
 * �츰 ����Ʈ ������ ������ �ʿ䰡 ����,
 * �ѹ��� ������ �ϰ� ���� ����� ��, ���α׷��� ������ �˴ϴ�.
*/
package sort;

public class QuickSearch {
	int quickSearch(int[] arr, int start, int end, int k) {
		int pivot = partition(arr, start, end);
		if(pivot == k) return arr[pivot];
		else if(pivot > k) return quickSearch(arr, start, pivot-1, k);
		else return quickSearch(arr, pivot+1, end, k);
		
	}
}
