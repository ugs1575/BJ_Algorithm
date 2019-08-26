package dynamic_programming;
import java.util.*;
import java.io.*;

public class Sticker {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		long ans = 0;
	
		while(t-- > 0) {
			ans = 0;
			int n = Integer.valueOf(br.readLine());
			long[][] a = new long[3][n+1];
			long[][] d = new long[n+1][3];
			
			String[] line = br.readLine().split(" ");
			for(int col=1; col<=n; col++) {
				a[1][col] = Long.valueOf(line[col-1]);
			}
			
			String[] line2 = br.readLine().split(" ");
			for(int col=1; col<=n; col++) {
				a[2][col] = Long.valueOf(line2[col-1]);
			}
			
			
			for(int x=1; x<=n; x++) {
				d[x][0] = Math.max(d[x-1][0],Math.max(d[x-1][1],d[x-1][2]));
				d[x][1] = Math.max(d[x-1][0],d[x-1][2])+a[2][x];
				d[x][2] = Math.max(d[x-1][0],d[x-1][1])+a[1][x];
			}
			ans = Math.max(d[n][0],Math.max(d[n][1],d[n][2]));
			System.out.println(ans);
			
		}
		
	}
		
	
	
	
}
