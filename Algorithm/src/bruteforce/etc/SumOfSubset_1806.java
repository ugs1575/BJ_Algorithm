package bruteforce.etc;

import java.util.Scanner;

public class SumOfSubset_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n+1];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = a[0];
        int min = 100001;
        while (left <= right && right < n){
            System.out.println(left+"/"+right+"/"+sum);
            if(sum < s){
                System.out.println("작아");
                right += 1;
                sum += a[right];
            }else if(s <= sum){
                System.out.println("같거나 크다");
                sum -= a[left];
                if(right-left+1 < min){
                    min = right-left+1;
                }
                left += 1;
                if(left > right && left < n){
                    right = left;
                    sum = a[left];
                }
            }
        }

        if(min == 100001) min = 0;

        System.out.println(min);
    }
}
