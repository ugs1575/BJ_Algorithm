package bruteforce.etc;

import java.util.*;

public class FourNumbers_7453 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        int index = 0;
        int[] first = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                first[index++] = a[i]+b[j];
            }
        }

        index = 0;
        int[] second = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                second[index++] = c[i]+d[j];
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int left = 0;
        int right = n*n-1;
        int ans = 0;
        while (left < n*n && right >= 0){
            int c1 = 1;
            int c2 = 1;
            if(first[left]+second[right] == 0){
                while (left < n*n-1 && first[left] == first[left+1]){
                    c1 += 1;
                    left += 1;
                }
                while (right > 0 && second[right] == second[right-1]){
                    c2 += 1;
                    right -= 1;
                }
                ans += c1*c2;
                left += 1;
                right -= 1;
            }else if(first[left]+second[right] > 0){
                right -= 1;
            }else{
                left += 1;
            }
        }

        System.out.println(ans);
    }
}
