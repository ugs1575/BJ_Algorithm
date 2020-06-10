/*4
1 2 3 4

1 2 4 3

5
5 4 3 2 1

*/

package bruteForce;

import java.util.*;

public class NextPermutation_10972 {
	static int n;
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
		
		for(int i=0; i<n; i++) {
			permutation += sc.nextInt();
			if(i != n-1) permutation += " ";
			arr[i] = i+1;
		}
		
		
		permute(0, permutation);
		/*Iterator<String> i = lhs.iterator();
	
		while(i.hasNext()) {
			String value = i.next().toString();
			
			if(find) {
				System.out.println(value);
				break;
			}
			
			if(value.equals(permutation)) {
				find = true;
				if(!i.hasNext())
					System.out.println(-1);
			}
			
		}*/
		
		
	}
	
	public static void permute(int index, String permutation) {
		if(index == n) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				sb.append(ans[i]);
				if(i != n-1) sb.append(" ");
			}
			if(sb.toString() == permutation) {
				find = true;
			}
			
			if(find) {
				lhs.add(sb.toString());
				find = false;
			}
		}else {
			for(int i=0; i<n; i++) {
				if(check[arr[i]]) continue;
				ans[index] = arr[i];
				check[arr[i]] = true;
				permute(index+1);
				check[arr[i]] = false;
			}
		}
	}
	

}
