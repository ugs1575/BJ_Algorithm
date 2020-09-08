package bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BitOperation_11723 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(bf.readLine());
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        int set = 0;

        for(int i=0; i<cnt; i++){
            String input = sc.next();

            switch (input){
                case "add" :
                    int num = sc.nextInt()-1;
                    set = (set | (1 << num));
                    //System.out.println(num+" : "+set);
                    break;
                case "check" :
                    int num2 = sc.nextInt()-1;
                    int set2 = (set & (1 << num2));
                    System.out.print(num2+" : ");
                    if(set2 == 0){
                        System.out.println(0);
                    }else{
                        System.out.println(1);
                    }
                    break;
                case "remove" :
                    int num3 = sc.nextInt()-1;
                    set = (set &~ (1 << num3));
                    //System.out.println(num3+" : "+set);
                    break;
                case "toggle" :
                    int num4 = sc.nextInt()-1;
                    set = (set ^ (1 << num4));
                    //System.out.println(num4+" : "+set);
                    break;
                case "all" :
                    set = (1 << 20) - 1;
                    System.out.println(set);
                    break;
                case "empty" :
                    set = 0;
                    //System.out.println(set);
                    break;
            }



        }




    }
}
