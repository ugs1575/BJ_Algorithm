/*4
1 2 3 4

4
1 2 4 3

5
5 4 3 2 1

1
1

2
1 2

7
1 2 3 4 5 6 7

*/

package bruteForce;

import java.util.*;

public class NextPermutation_10972 {
	public static int[] swap(int[] data, int left, int right) {
		 // Swap the data 
        int temp = data[left]; 
        data[left] = data[right]; 
        data[right] = temp; 
  
        // Return the updated array 
        return data; 
	}
	
	public static int[] reverse(int[] data, int left, int right) {
		while(left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}
		
		return data;
	}
	
	public static boolean findNextPermutation(int[] data) {
		if(data.length <= 1) {
			return true;
		}
		
		//오른쪽->왼쪽 가장 긴 내림차순을 찾는다
		int last = data.length-2;
		
		while(last >= 0) {
			if(data[last] < data[last+1]) {
				break;
			}
			last --;
		}
		
		//마지막 순열일 때
		if(last < 0) {
			return false;
		}
		
		int nextGreater = data.length - 1;
		
		//suffix 중 pivot 보다 큰 값들 중 가장 작은 값을 찾는다.
		for(int i=data.length - 1; i>last; i--) {
			if(data[i] > data[last]) {
				nextGreater = i;
				break;
			}
		}
		
		data = swap(data, nextGreater, last);
		
		data = reverse(data, last+1, data.length-1);
		
		return true;
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] data = new int[n];
		
		for(int i=0; i<n; i++) {
			data[i] = sc.nextInt();
		}
		
		if (!findNextPermutation(data)) 
            System.out.println("-1"); 
        else { 
        	for(int i=0; i<n; i++) {
				System.out.print(data[i]);
				if(i != n-1) System.out.print(" ");
			}
        } 
	}
	
	

}
