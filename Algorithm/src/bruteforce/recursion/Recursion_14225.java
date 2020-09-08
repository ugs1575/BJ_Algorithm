package bruteforce.recursion;

import java.util.Scanner;

public class Recursion_14225 {
    static boolean[] check;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        check = new boolean[2000000];

        go(arr, 0, 0);

        for(int i=0; i<2000000; i++){
            if(!check[i]){
                System.out.println(i);
                break;
            }
        }
    }

    public static void go(int[] arr, int index, int sum){
        if(index == arr.length){
            check[sum] = true;
            return;
        }

        go(arr, index+1, sum+arr[index]);
        go(arr, index+1, sum);
    }
}
