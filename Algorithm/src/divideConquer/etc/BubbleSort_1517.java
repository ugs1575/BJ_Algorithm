package divideConquer.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BubbleSort_1517 {
    static long swap = 0;
    static long[] sortedArr;
    public static void merge(long[] arr, int l, int r, int m){
        int i = l;
        int j = m+1;
        int index = l;

        while (i<=m && j<=r){
            if(arr[i] <= arr[j]){
                sortedArr[index++] = arr[i++];
            }else{
                sortedArr[index++] = arr[j++];
                swap += (m-i+1);
            }
        }

        while (i<=m) sortedArr[index++] = arr[i++];
        while (j<=r) sortedArr[index++] = arr[j++];

        for(int k=l; k<=r; k++){
            arr[k] = sortedArr[k];
        }
    }


    public static void mergeSort(long[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, r, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sortedArr = new long[n];
        String[] a = br.readLine().split(" ");
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(a[i]);
        }

        mergeSort(arr, 0, n-1);
        System.out.println(swap);
    }
}
