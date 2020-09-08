package bruteforce.permutation;

import java.util.Scanner;

public class Resign_14501 {
    static int[] day, pay;
    static int max=0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        day = new int[n+1];
        pay = new int[n+1];

        for(int i=1; i<=n; i++){
            day[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            int[] ans = new int[i];
            boolean[] check = new boolean[n+1];
            permutation(1, n, i, 0, check, ans);
        }

        System.out.println(max);
    }

    public static void permutation(int start, int resignDay, int n, int index, boolean[] check, int[] ans){
        if(index == n){
            int totalPay = 0;
            int totalDay = ans[0];
            boolean pass = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                if(ans[i] < totalDay){
                    pass = true;
                    break;
                }

                totalDay = ans[i]+day[ans[i]];

                if(totalDay > resignDay+1){
                    pass = true;
                    break;
                }

                totalPay += pay[ans[i]];
                sb.append(ans[i]);
            }
            //if(!pass) System.out.println(sb+"/"+totalPay+"/"+totalDay);

            if(!pass && totalPay > max)
                max = totalPay;

        }else{
            for(int i=start; i<=resignDay; i++){
                if(check[i]) continue;
                ans[index] = i;
                check[i] = true;
                permutation(i+1, resignDay, n, index+1, check, ans);
                check[i] = false;
            }
        }

    }
}
