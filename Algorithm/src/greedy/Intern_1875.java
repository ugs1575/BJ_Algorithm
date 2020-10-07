package greedy;

import java.util.Scanner;

public class Intern_1875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        while (m >= 2 && n >= 1 && m+n >= k+3){
            ans += 1;
            m -= 2;
            n -= 1;
        }

        System.out.println(ans);


    }
}
