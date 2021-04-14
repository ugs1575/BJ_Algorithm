package bruteforce.etc;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSubset2_1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int m = n/2;
        n = n-m;
        int[] first = new int[1<<n];
        for(int i=0; i<(1<<n); i++){
            for(int k=0; k<n; k++){
                if ((i&(1<<k)) > 0){
                    first[i] += a[k];
                }
            }
        }

        int[] second = new int[1<<m];
        for(int i=0; i<(1<<m); i++){
            for(int k=0; k<m; k++){
                if((i&(1<<k)) > 0){
                    second[i] += a[k+n];
                }
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);
        n = (1<<n);
        m = (1<<m);
        int left = 0;
        int right = m-1;
        long ans = 0;
        while (left < n && right >= 0){
            System.out.println(left+"/"+right);
            if(first[left] + second[right] == s){
                System.out.println("같다");
                long c1 = 1;
                long c2 = 1;
                while (left < n-1 && first[left] == first[left+1]){
                    c1 += 1;
                    left += 1;
                }
                while (right > 0 && second[right] == second[right-1]){
                    c2 += 1;
                    right -= 1;
                }
                left += 1;
                right -= 1;
                ans += c1*c2;
            }else if(first[left]+second[right] > s){
                System.out.println("크다 ");
                right -= 1;
            }else{
                System.out.println("작 다");
                left += 1;
            }
        }

        if(s == 0) ans -= 1; //부분수열의 크기가 양수이어야 하기 때문에
        System.out.println(ans);
    }
}
