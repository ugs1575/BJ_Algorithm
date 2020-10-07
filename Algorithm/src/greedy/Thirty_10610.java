/*
* 30은 2*3*5이다
* 즉, N이 30으로 나누어 떨어지려면, 2, 3, 5로 나누어 떨어져야한다
* 2로 나누어 떨어지는 수  : 마지막 자리가 짝수
* 3으로 나누어 떨어지는 수 : 자리의 합이 3으로 나누어 떨어져야 함
* 5로 나누어 떨어지는 수  : 마지막 자리가 0 또는 5
* 30으로 나누어 떨어지는 수 : 마지막자리가 0이면서 자리의 합이 3으로 나누어 떨어져야함
* */

package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Thirty_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] a = new int[n.length()];
        int sum = 0;
        for(int i=0; i<n.length(); i++){
            a[i] = n.charAt(i) - '0';
            sum += a[i];
        }
        Arrays.sort(a);
        if(a[0] == 0 && sum%3 == 0){
            for(int i=n.length()-1; i>=0; i--){
                System.out.print(a[i]);
            }
        }else{
            System.out.println(-1);
        }
    }
}
