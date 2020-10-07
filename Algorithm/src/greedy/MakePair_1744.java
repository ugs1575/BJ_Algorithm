/*
* -고려 못했던 점들
* 1일 경우 (1*1)+1 보다 1+1+1 이 더 크다 -> 1일 경우 묶지 않는것이 최선이다
* minus는 reverse 해주어야함...
*
* */


package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MakePair_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        int n = sc.nextInt();
        int zero = 0;
        int one = 0;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num > 1){
                plus.add(num);
            }else if(num == 0){
                zero++;
            }else if(num == 1){
                one++;
            }else{
                minus.add(num);
            }
        }
        Collections.sort(plus);
        Collections.sort(minus);
        Collections.reverse(minus);
        long ans = one;
        int plus_last  = 1;
        int minus_last = 1;
        if(plus.size() % 2 != 0){
            ans += plus.get(0);
            plus_last = 2;
        }
        if(minus.size() % 2 != 0){
            if(zero == 0){
                ans += minus.get(0);
            }
            minus_last = 2;
        }

        if(plus.size() > 1){
            for(int i=plus.size()-1; i>=plus_last; i-=2){
                long multi = plus.get(i)*plus.get(i-1);
                ans += multi;
            }
        }

        if(minus.size() > 1){
            for(int i=minus.size()-1; i>=minus_last; i-=2){
                long multi = minus.get(i)*minus.get(i-1);
                ans += multi;
            }
        }

        System.out.println(ans);
    }
}
