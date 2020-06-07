package bruteforce;

import java.util.Scanner;

public class NM2_15650 {
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=1; i<=n; i++){
            arr[i-1] = i;
        }

        combinationUtil(arr, n, m);
    }

    public static void combinationUtil(int[] arr, int n, int r){
        int[] data = new int[r];

        printCombination(data, arr, 0, n-1, r, 0);
    }

    public static void printCombination(int[] data, int[] arr, int start, int end, int r, int index){
        if(index == r){
            for(int i=0; i<r; i++){
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }else{
            for(int i=start; i<=end && end-i+1>=r-index; i++){
                System.out.println(end-i+1);
                data[index] = arr[i];
                printCombination(data, arr, i+1, end, r, index+1);
            }
        }

    }
}
