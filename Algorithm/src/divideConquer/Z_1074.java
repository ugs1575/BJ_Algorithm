package divideConquer;

import java.util.Scanner;

public class Z_1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        n = (int) Math.pow(2,n);
        int x = 0;
        int y = 0;
        int count = 0;

        while (n > 0){
            n = n/2;
            if(r < x+n){
                if(c < y+n) {
                    count += n * n * 0;
                }else{
                    count += n * n * 1;
                    y += n;
                }
            }else{
                if(c < y+n){
                    count += n * n * 2;
                    x += n;
                }else{
                    count += n * n * 3;
                    x += n;
                    y += n;
                }
            }

            if(n == 1){
                System.out.println(count);
            }
        }


    }
}
