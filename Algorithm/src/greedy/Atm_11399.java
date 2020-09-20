package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Atm_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += a[i];
            ans += sum;
        }

        System.out.println(ans);
    }
}
