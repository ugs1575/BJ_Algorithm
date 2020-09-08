package bruteforce;

import java.util.*;

/*4 2
9 7 9 1

1 1
1 7
1 9
7 7
7 9
9 9*/
public class NM12_15666 {
	static int n, m;
	static int[] arr, ans;
	static boolean[] check;
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
		
		permute(0, 0);
		
		Iterator<String> i = lhs.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
	}
	
	public static void permute(int index, int start) {
		if(index == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				sb.append(ans[i]);
				if(i != m-1) sb.append(" ");
			}
			
			lhs.add(sb.toString());
		}else {
			for(int i=start; i<n; i++) {
				ans[index] = arr[i];
				permute(index+1, i);
				
			}
		}
	}

}
