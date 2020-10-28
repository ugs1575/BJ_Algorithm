package bruteforce;

import java.util.*;

public class RomeNum_16922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[50*20+1];

        for(int i=0; i<=n; i++){
            for(int v=0; v<=n-i; v++){
                for(int x=0; x<=n-i-v; x++){
                    int l = n-i-v-x;
                    check[i+(v*5)+(x*10)+(l*50)] = true;
                }
            }
        }

        int ans = 0;
        for(int i=1; i<50*20+1; i++){
            if(check[i]) ans ++;
        }

        System.out.println(ans);

    }
}
