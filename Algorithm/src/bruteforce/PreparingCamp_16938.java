package bruteforce;

import java.util.Scanner;

public class PreparingCamp_16938 {
    static int n, l, r, x;
    static int[] a;
    static int combination(int start, int end, int index, int[] temp, int cnt, int max){
        int total = 0;
        if(cnt == max){
            int low = Integer.MAX_VALUE;
            int high = 0;
            int sum = 0;
            for(int i=0; i<max; i++){
                low = Math.min(temp[i], low);
                high = Math.max(temp[i], high);
                sum += temp[i];
            }
            //System.out.println(sum+"/"+low+"/"+high);
            if(sum >= l && sum <= r && (high-low) >= x) return 1;
            else return 0;
        }

        for(int i=start; i<=end; i++){
            temp[index] = a[i];
            total += combination(i+1, end, index+1, temp, cnt+1, max);
        }

        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i=2; i<=n; i++){
            int[] temp = new int[i];
            ans += combination(0, n-1, 0, temp, 0, i);
        }
        System.out.println(ans);
    }
}
