package bruteforce.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MakingPassword_1759_ans {
    public static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }
    public static void go(int n, String[] alpha, String password, int i) {
        System.out.println(password);
        System.out.println("i"+i);

        if (i >= alpha.length) return;
        go(n, alpha, password+alpha[i], i+1);
        go(n, alpha, password, i+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] alpha = new String[m];
        for (int i=0; i<m; i++) {
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);

        go(n, alpha, "", 0);
    }
}
