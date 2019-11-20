/*두번째 그림이 한번 정렬을 거친 후입니다.
 * 여기서 확실히 알 수 있는 한가지 정보가 있습니다.
 * pivot의 값은 4번째 위치라는 것입니다.
 * 만약 문제가 정렬 후, 4번째 위치의 숫자를 출력하라 였다면
 * 우린 퀵소트 과정을 전부할 필요가 없고,
 * 한번의 과정만 하고 값을 출력한 뒤, 프로그램을 끝내면 됩니다.
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
