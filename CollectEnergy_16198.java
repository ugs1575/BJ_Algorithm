package bruteforce.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectEnergy_16198 {
    static int[] arr;
    static boolean[] check;
    static int n, max;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        max = Integer.MIN_VALUE;
        arr = new int[n];
        check = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        go(n-2, 0);

        System.out.println(max);
    }

    public static void go(int cnt, int e){
        //System.out.println("cnt : "+cnt+" e: "+e);
        //고를 숫자가 없는 경우
        if(cnt < 0) return;

        //마지막 숫자를 고른 경우
        if(cnt == 0){
            if(e > max) max = e;
            return;
        }

        for(int i=1; i<n-1; i++){
            if(check[i]) continue;
            check[i] = true;
            int temp = getEnergy(i);
            go(cnt-1, e+temp);
            check[i] = false;
        }

    }

    public static int getEnergy(int index){
        int ans = 0;
        for(int i=index-1; i>=0; i--){
            if(!check[i]) {
                ans = arr[i];
                break;
            }
        }

        for(int i=index+1; i<n; i++){
            if(!check[i]){
                ans *= arr[i];
                break;
            }
        }

        return ans;
    }
}
