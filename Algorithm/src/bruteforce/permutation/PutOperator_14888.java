package bruteforce.permutation;

import java.util.Scanner;

public class PutOperator_14888 {
    static int n, min, max, signTotal;
    static boolean[] check;
    static int[] ans, aNum, aSignInt;
    public static void main(String args[]){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        Scanner sc = new Scanner(System.in);
        n           = sc.nextInt();
        aNum        = new int[n];
        signTotal   = n-1;
        aSignInt    = new int[signTotal];
        check       = new boolean[signTotal];
        ans         = new int[signTotal];
        int[] aSign = new int[4];

        for(int i=0; i<n; i++){
            aNum[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            aSign[i] = sc.nextInt();
        }

        int start = 0;
        int end   = 0;
        for(int i=1; i<=4; i++){
            end = start + aSign[i-1];
            for(int j=start; j<end; j++){
                aSignInt[j] = i;
            }
            start = end;
        }

        permutation(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void permutation(int index){
        if(index == signTotal){
            /*for(int i=0; i<signTotal; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();*/
            int res = aNum[0];
            for(int i=0; i<signTotal; i++){
                int sign = ans[i];
                switch (sign){
                    case 1 : //+
                        res += aNum[i+1];
                        break;
                    case 2 : //-
                        res -= aNum[i+1];
                        break;
                    case 3 : //x
                        res *= aNum[i+1];
                        break;
                    case 4 : //x
                        res /= aNum[i+1];
                        break;
                }
            }
            //System.out.println(res);
            max = Math.max(res, max);
            min = Math.min(res, min);
        }else{
            for(int i=0; i<signTotal; i++){
                if(check[i]) continue;
                check[i] = true;
                ans[index] = aSignInt[i];
                permutation(index+1);
                check[i] = false;
            }
        }
    }
}
