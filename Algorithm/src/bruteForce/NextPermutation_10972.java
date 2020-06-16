/*4
1 2 3 4

4
1 2 4 3

5
5 4 3 2 1

1
1

*/

package bruteForce;

import java.util.*;

public class NextPermutation_10972 {
	public static int[] swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
		return arr;
	}
	
	public static int[] reverse(int[] arr, int start, int last) {
		while(start < last) {
			int temp = arr[start];
			arr[start++] = arr[last];
			arr[last--] = temp;
		}
		
		return arr;
	}
	
	public static boolean next_permutation(int[] arr) {
		//오른쪽->왼쪽 가장 긴 내림차순을 찾는다
		int pivot = arr[arr.length-2];
		int pivotIdx = arr.length-2;
		boolean finalPermute = false;
		
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] < arr[i+1]) {
				pivot = arr[i];
				pivotIdx = i;
				break;
			}
			
			if(i == 0)
				finalPermute = true;
		}
		
		System.out.println("pivotIdx : "+pivotIdx);
		
		//마지막 순열일 때
		if(finalPermute) {
			return false;
		}
		
		int min = arr[pivotIdx+1];
		int minIdx = pivotIdx+1;
		
		//suffix 중 pivot 보다 큰 값들 중 가장 작은 값을 찾는다.
		for(int i=pivotIdx+2; i<arr.length; i++) {
			if(arr[i] > pivot && min > arr[i] ) {
				min = arr[i];
				minIdx = i;
			}
		}
		
		System.out.println("minIdx : "+minIdx);
		
		arr = swap(arr, pivotIdx, minIdx);
		
		System.out.print("after swapping : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		arr = reverse(arr, pivotIdx+1, arr.length-1);
		System.out.print("after reverse : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		return true;
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean finalPermutation = true;
		if(n != 1) {
			finalPermutation = next_permutation(arr);
		}
		
		
		if(finalPermutation) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]);
				if(i != n-1) System.out.print(" ");
			}
		}else {
			System.out.print(-1);
		}
	}
	
	

}
