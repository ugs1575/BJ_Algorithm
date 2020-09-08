package bruteforce.permutation;

import java.util.Scanner;

public class Sum123_9095 {
    static int[] num = {1, 2, 3};
    static int cnt=0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] output = new int[t];
        for(int i=0; i<t; i++){
            //System.out.println("t : "+t);
            int n = sc.nextInt();
            //System.out.println("n: "+n);
            for(int j=n; j>0; j--){
                int[] ans = new int[j];
                combination(ans, j, n, 0);
            }
            output[i] = cnt;
            cnt = 0;
        }

        for(int i=0; i<t; i++){
            System.out.println(output[i]);
        }
    }

    public static void combination(int[] ans, int j, int n,  int index){
        if(index == j){
            int sum = 0;
            for(int i=0; i<j; i++){
                sum += ans[i];
                //System.out.print(ans[i]+" ");
            }
            //System.out.println();

            if(sum == n)
                cnt++;
        }else{
            for(int i=0; i<3; i++){
                ans[index] = num[i];
                combination(ans, j, n, index+1);
            }
        }
    }
}
