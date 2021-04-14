package bruteforce.etc;

import java.util.*;

public class NM9_15663 {
	static int n, m;
	static int[] ans, arr;
	static boolean[] check; 
	static LinkedHashSet<String> hs;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		ans = new int[m];
		arr = new int[n];
		check = new boolean[n]; 
		hs = new LinkedHashSet<String>();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		permute(0, 0);
		
		Iterator<String> i = hs.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
	}
	
	public static void permute(int index, int parent) {
		if(index == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				sb.append(ans[i]);
				if(i != m-1) sb.append(" ");
			}
			hs.add(sb.toString());
		}else {
			for(int i=0; i<n; i++) {
				if(check[i]) continue;
				check[i] = true;
				ans[index] = arr[i];
				permute(index+1, i);
				check[i] = false;
			}
			
		}
		
		
	}

}
