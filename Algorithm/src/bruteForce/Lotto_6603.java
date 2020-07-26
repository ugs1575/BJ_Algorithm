package bruteforce;

import java.util.Scanner;

public class Lotto_6603 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while(true){
            int k = sc.nextInt();
            if(k == 0)
                break;
            int[] number = new int[k];
            int[] ans = new int[6];

            for(int i=0; i<k; i++){
                number[i] = sc.nextInt();
            }

            combination(0, k-1, 0, ans, number, k);
            System.out.println();
        }
    }

    public static void combination(int start, int end, int index, int[] ans, int[] number, int k){
        if(index == 6){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++){
                sb.append(ans[i]);
                if(i != 5) sb.append(" ");
            }
            System.out.println(sb);
        }else{
            for(int i=start; i<=end; i++){
                ans[index] = number[i];
                combination(i+1, end,index+1, ans, number, k);
            }
        }
    }
}
