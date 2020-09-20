package greedy;

import java.util.Scanner;

public class Coin0_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            coin[i] = sc.nextInt();
            if(k >= coin[i]) max = i;
        }

        int ans = 0;
        while (true){
            ans += k/coin[max];
            k %= coin[max];
            if(k == 0) break;
            max --;
        }

        System.out.println(ans);
    }
}
