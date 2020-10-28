package bruteforce;

import java.util.Scanner;

public class Chicken_16917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int total = 0;
        int price = 0;

        if(c*2 < a+b){
            price = c*2;
        }else{
            price = a+b;
        }


        int min = Math.min(x, y);
        total = price * min;

        x -= min;
        y -= min;

        if(x > 0){
            if(a > price) a = price;
            total += (a*x);
        }
        if(y > 0){
            if(b > price) b = price;
            total += (b*y);
        }

        System.out.println(total);

    }
}
