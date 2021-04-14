package bruteforce.etc;

import java.util.Scanner;

public class AtoB_16953 {
    static int change(long a, int b, int oper){
        //System.out.println("a : "+a+"/ b : "+b+" / oper : "+oper);
        int ans = -1;
        if(a > b){
            return -1;
        }
        if(a == b){
            return oper;
        }
        int res = change(a*2, b, oper+1);
        int res2 = change(a*10+1, b, oper+1);
        if(res == -1 && res2 == -1) return -1;
        if(res == -1) return res2;
        if(res2 == -1) return res;
        int min = Math.min(res,res2);
        if(ans > min) ans = min;

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();

        System.out.println(change(a, b, 1));
    }
}
