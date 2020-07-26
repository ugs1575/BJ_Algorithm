package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class StartAndLink_14889 {
    static int min, allCnt, teamCnt;
    static int[][] power;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        allCnt = sc.nextInt();
        teamCnt = allCnt/2;
        min = Integer.MAX_VALUE;
        power = new int[allCnt+1][allCnt+1];

        int[] member = new int[allCnt];
        int[] ans = new int[teamCnt];

        for(int i=1; i<=allCnt; i++){
            for(int j=1; j<=allCnt; j++){
                power[i][j] = sc.nextInt();
            }
            member[i-1] = i;
        }

        combination(0, allCnt-1, ans, member, 0);

        System.out.println(min);
    }



    public static void combination(int start, int end, int[] ans, int[] member, int index){
        if(index == teamCnt){
            boolean check[] = new boolean[allCnt+1];
            for(int i=0; i<teamCnt; i++){
                check[ans[i]] = true; //true -> start 팀
            }

            int startPower = 0;
            //start팀 능력치 구하기
            for(int i=1; i<=allCnt; i++){
                if(check[i]){
                    for(int j=1; j<=allCnt; j++){
                        if(i == j) continue;
                        if(check[j]){
                            startPower += power[i][j];
                        }
                    }
                }
            }

            int linkPower = 0;
            //link팀 능력치 구하기
            for(int i=1; i<=allCnt; i++){
                if(!check[i]){
                    for(int j=1; j<=allCnt; j++){
                        if(i == j) continue;
                        if(!check[j]){
                            linkPower += power[i][j];
                        }
                    }
                }
            }

            int diff = Math.abs(startPower - linkPower);

            if(min > diff)
                min = diff;


        }else{
            for(int i=start; i<=end && end-start+1 >= teamCnt-index; i++){
                ans[index] = member[i];
                combination(i+1, end, ans, member, index+1);
            }
        }
    }

}
