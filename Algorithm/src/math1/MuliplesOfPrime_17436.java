package Math;

import java.util.Scanner;

public class MuliplesOfPrime_17436 {
    static int n;
    static long m;
    static int[] a;
    static long go(int index, long num){
        if(index >= n) return 0;
        long ans = 0;
        if(num*a[index] > m) return 0;
        ans += m/(num*a[index]);
        ans += go(index+1, num);
        ans -= go(index+1, num*a[index]);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextLong();
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        //방법2
        System.out.println(go(0,1));


        //방법1
        /*long ans = 0;
        for(int i=1; i<(1<<n); i++){ //모든 경우의 수 만들어주기 (2의 배수, 3의 배수, 5의 배수, 2x3의 배수...) 포함여부
            int cnt = 0;
            long p = 1;
            for(int j=0; j<n; j++){
                if((i&(1<<j)) > 0){
                    p *= a[j];
                    cnt += 1;
                    if(p > m){
                        cnt = -1;
                        break;
                    }
                }
            }

            if(cnt == -1) continue;
            if(cnt % 2 == 0){
                ans -= (m/p);
            }else{
                ans += (m/p);
            }
        }

        System.out.println(ans);*/
    }
}
