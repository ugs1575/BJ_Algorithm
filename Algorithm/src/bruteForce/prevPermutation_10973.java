/*5
1 2 4 3 5*/

package bruteForce;

import java.util.*;

public class prevPermutation_10973 {
	public static int[] reverse(int[] data, int left, int right) {
		
		while(left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}
		
		return data;
	}


	public static int[] swap(int[] data, int left, int right) {
		
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		
		return data;
	}
	
	
	public static boolean findPrevPermutation(int[] data) {
		if(data.length == 1) {
			return true;
		}
		
		//�����ʺ��� ���� �� ������ ���� ã�´�.
		int last = data.length - 2;
		while(last >= 0) {
			if(data[last] > data[last+1]) {
				break;
			}
			last --;
		}
		
		//����, last �� 0���� ������ ù��° ����
		if(last < 0) {
			return false;
		}
		
		//�����ʺ��� last ���� ���� last���� ���� ���� ã�´�.
		int nextLower = data.length - 1;
		while(nextLower > last){
			if(data[nextLower] < data[last]) {
				break;
			}
			nextLower --;
		}
		
		data = swap(data, last, nextLower);
		
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
		
		if(findPrevPermutation(data)) {
			for(int i=0; i<n; i++) {
				System.out.print(data[i]);
				if(i != n-1) System.out.print(" ");
			}
		}else {
			System.out.print(-1);
		}
	}

}
