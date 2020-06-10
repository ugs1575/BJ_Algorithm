package bruteForce;

import java.util.*;

public class NM11_15665 {
	static int n, m;
	static int[] arr, ans;
	static LinkedHashSet<String> lhs;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		lhs = new LinkedHashSet<String>();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		permute(0);
		
		Iterator<String> i = lhs.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
	
	public static void permute(int index) {
		if(index == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				sb.append(ans[i]+" ");
			}
			
			lhs.add(sb.toString());
		}else {
			for(int i=0; i<n; i++) {
				ans[index] = arr[i];
				permute(index+1);
			}
		}
	}

}
