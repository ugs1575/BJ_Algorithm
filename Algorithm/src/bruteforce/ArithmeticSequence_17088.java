/*
* 처음 두 개의 수가 정해지면, 등차수열을 만들 수 있다
* 처음 두 개의 수를 정하는 방법은 총 3x3=9가지가 있고, 이걸 모두 시도해보면 된다.
*
* */

package bruteforce;

import java.util.Scanner;

public class ArithmeticSequence_17088 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        if(n == 1){
            System.out.println(0);
            System.exit(0);
        }

        boolean res = false;
        int min = n;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                int change = 0;
                if(d1 != 0) change+=1;
                if(d2 != 0) change+=1;
                boolean ok = true;
                int a0 = b[0]+d1;
                int diff = (b[1]+d2)-a0;
                int next = a0+diff;
                for(int i=2; i<n; i++){
                    next += diff;
                    if(b[i] == next) continue;
                    if(b[i]-1 == next) {
                        change += 1;
                        continue;
                    }
                    if(b[i]+1 == next) {
                        change += 1;
                        continue;
                    }
                    ok = false;
                    break;
                }
                if(ok){
                    res = true;
                    min = Math.min(change, min);
                }
            }
        }

        if(!res) System.out.println(-1);
        else System.out.println(min);
    }

}
