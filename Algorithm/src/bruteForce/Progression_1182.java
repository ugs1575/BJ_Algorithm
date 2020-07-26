package bruteforce;

import java.util.Scanner;

public class Progression_1182 {
    static int cnt,n,s,ans;
    static int[] arr;
    //static int[] aAns;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        cnt = 0;
        ans = 0;
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
           // aAns = new int[i];
            permutation(0, i, 0);
            //System.out.println("ans"+ans);
        }

        System.out.println(cnt);
    }

    public static void permutation(int index, int max, int start){
        if(index == max){
            int sum = 0;
            for(int i=0; i<n; i++){
                int isIncluded = ans & (1 << i);
                if(isIncluded != 0){
                    sum += arr[i];
                    //ystem.out.print(arr[i]+" ");
                }
            }
            //System.out.println();

            if(sum == s) {
                //System.out.print("!!");
                cnt ++;
            }

        }else{
            for(int i=start; i<n && max-index <= n-i ; i++){
                ans = ans | (1 << i);
                permutation(index+1, max, i+1);
                ans = ans &~ (1 << i);
            }
        }
    }

    /*public static void permutation(int index, int max, int start){
        if(index == max){
            System.out.print("kk");
            for(int i=0; i<max; i++){
                System.out.print(aAns[i]+" ");
            }
            System.out.println();

        }else{
            for(int i=start; i<n && max-index <= n-i ; i++){
                System.out.println(start);
                aAns[index] = arr[i];
                permutation(index+1, max, i+1);
            }
        }
    }*/


}
