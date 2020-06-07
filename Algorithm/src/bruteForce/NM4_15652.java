package bruteforce;

import java.util.*;

public class NM4_15652 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=1; i<=n; i++){
            arr[i-1] = i;
        }

        permutationUtil(n, m, arr);

    }

    public static void permutationUtil(int n, int r, int[] arr){
        int[] data = new int[r];

        printPermutation(data, n, r, 0, n-1, 0, arr);
    }

    public static void printPermutation(int[] data, int n, int r, int start, int end, int index, int[] arr){
        if(index == r){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<r; i++){
                sb.append(data[i]);
                if(i!=r-1) sb.append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=start; i<=end; i++){
            data[index] = arr[i];
            printPermutation(data, n, r, i, end, index+1, arr);
        }
    }
}
