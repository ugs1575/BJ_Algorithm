package bruteforce;

import java.util.*;

public class SevenDwarfs_2309 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] tall = new int[9];
        int sum = 0;
        int ans1 = 0;
        int ans2 = 0;

        for(int i=0; i<9; i++){
            tall[i] = sc.nextInt();
            sum += tall[i];
        }

        Arrays.sort(tall);

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                int twoSum = tall[i]+tall[j];
                if(sum - twoSum == 100){
                    ans1 = i;
                    ans2 = j;
                    break;
                }
            }

            if(ans1 != 0 && ans2 != 0) break;
        }

        for(int i=0; i<9; i++){
            if(i != ans1 && i != ans2){
                System.out.println(tall[i]);
            }
        }
    }
}
