/*4
1 2 3 4

1 2 4 3

5
5 4 3 2 1

*/

package bruteForce;

import java.util.*;

public class NextPermutation_10972 {
	static int n, cnt, ansCnt;
	static int[] arr, ans;
	static boolean[] check;
	static LinkedHashSet<String> lhs;
	static boolean find;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		check = new boolean[10001];
		lhs = new LinkedHashSet<String> ();
		arr = new int[n];
		ans = new int[n];
		String permutation = "";
		find = false;
		ansCnt = 1;
		cnt = 0;
				
		for(int i=0; i<n; i++) {
			permutation += sc.nextInt();
			if(i != n-1) permutation += " ";
			arr[i] = i+1;
			ansCnt = ansCnt*(i+1);
		}
		
		permute(0, permutation);
		
		Iterator<String> i = lhs.iterator();
	
		String value = i.next().toString();
		System.out.println(value);
		
		
	}
	
	public static void permute(int index, String permutation) {
		if(index == n) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				sb.append(ans[i]);
				if(i != n-1) sb.append(" ");
			}
			
			
			cnt ++;
			
			if(find) {
				lhs.add(sb.toString());
				find = false;
			}else if(sb.toString().equals(permutation)) {
				find = true;
				if(cnt == ansCnt) {
					int minusOne = -1;
					lhs.add(String.valueOf(minusOne));
				}
			}
			
			
		}else {
			for(int i=0; i<n; i++) {
				if(check[arr[i]]) continue;
				ans[index] = arr[i];
				check[arr[i]] = true;
				permute(index+1, permutation);
				check[arr[i]] = false;
			}
		}
	}
	

}
