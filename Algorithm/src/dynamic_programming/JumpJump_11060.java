package dynamicProgramming;

import java.util.Scanner;

public class JumpJump_11060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            d[i] = -1;
        }

        d[0] = 0;
        for(int i=0; i<n; i++){
            if(d[i] == -1) continue;
            for(int j=1; j<=a[i]; j++){
                int idx = i+j;
                if(idx < n){
                    if(d[idx] == -1){
                        d[idx] = d[i]+1;
                    }else{
                        d[i+j] = Math.min(d[i+j], d[i]+1);
                    }
                }
            }
        }

        System.out.println(d[n-1]);

    }
}
