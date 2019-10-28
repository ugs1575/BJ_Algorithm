package math1;
import java.util.*;

public class FactorialZero {
	public static long fac(int n) {
		long one = 1L;
		if(n==1) {
			return one;
		}else {
			return n*fac(n-1);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = fac(n);
		System.out.print(ans);
		/*String ans2 = Integer.toString(ans);
		char[] char_arr = ans2.toCharArray();
		int cnt = 0;
		for(int i=char_arr.length-1; i>=0; i--) {
			int num = Character.getNumericValue(char_arr[i]);
			if(num == 0) {
				cnt ++;
			}else{
				break;
			}
		}
		
		System.out.print(cnt);*/
		
	}
	
/*	public static long fac(long n) {
		Long one = new Long(1);
		Long zero = new Long(0);
		Long nObj = new Long(n);
		int compareOne = nObj.compareTo(one);
		int compareZero = nObj.compareTo(zero);
		if( compareOne == 0 || compareZero == 0 ) {
			return one;
		}else {
			return n*fac(n-1);
		}
	}*/
}
