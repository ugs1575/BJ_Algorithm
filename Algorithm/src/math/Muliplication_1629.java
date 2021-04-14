package Math;

import java.util.Scanner;

public class Muliplication_1629 {
    static long calc(long a, long b, long c){
        long ans = 1;
        while (b>0){
            if(b%2 == 1){
                ans *= a;
                ans %= c;
            }
            a *= a;
            a %= c;
            b /= 2;
        }


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(calc(a,b,c));
    }
}
