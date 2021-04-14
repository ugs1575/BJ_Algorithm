package bruteforce.etc;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfPrimeNumber_1644 {
    static int n = 4000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        boolean[] prime = new boolean[n+1];

        for(int i=0; i<n; i++){
            prime[i] = true;
        }

        for(int p=2; p*p<=n; p++){
            if(prime[p]){
                for(int i=p*2; i<=n; i+=p){
                    prime[i] = false;
                }
            }
        }


        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=m; i++){
            if(prime[i]){
                list.add(i);
            }
        }
        list.add(0);
        /*for(int i:list){
            System.out.println(i);
        }*/

        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = list.get(0);
        while (left <= right && right < list.size()-1){
            if(sum < m){
                right += 1;
                sum += list.get(right);
            }else if(sum == m){
                ans += 1;
                right += 1;
                sum += list.get(right);
            }else{
                sum -= list.get(left);
                left += 1;
                if (right < left && left < list.size()-1){
                    right = left;
                    sum = list.get(left);
                }
            }
        }

        System.out.println(ans);
    }
}
