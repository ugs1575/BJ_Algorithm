package bruteforce;

import java.util.Scanner;

public class TwiceSum_12931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int oper = 0;
        while (true){
            boolean ok = true;
            for(int i:a){
                if(i != 0){
                    ok = false;
                }
            }

            if(ok) break;


            boolean even = true;
            for(int i:a){
                if(i%2 != 0){
                    even = false;
                }
            }

            if(even){
                for(int i=0; i<n; i++){
                    a[i] /= 2;
                }
                oper += 1;
            }else{
                for(int i=0; i<n; i++){
                    if(a[i]%2 != 0 && a[i] >= 1){
                        a[i] -= 1;
                        oper += 1;
                    }
                }
            }

            /*System.out.println(even+"/"+oper);
            for(int i:a){
                System.out.print(i+" ");
            }
            System.out.println();*/


        }

        System.out.println(oper);
    }
}
