package bruteforce;

import java.util.Scanner;

public class StartAndLinkBitMask_14889 {
    static int[][] aPower;
    static int total, team, min;
    static boolean[] check;
    static int[] ans;
    static int iAns = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        total = sc.nextInt();
        team = total/2;
        ans = new int[team];
        min = Integer.MAX_VALUE;
        aPower = new int[total+1][total+1];
        for(int i=1; i<=total; i++){
            for(int j=1; j<=total; j++){
                aPower[i][j] = sc.nextInt();
            }
        }
        check = new boolean[total+1];

        combination(0,1);

        //System.out.println(min);
    }

    public static void combination(int index, int start){
        if(index == team) {
            for(int i=0; i<team; i++){
                System.out.print(ans[i]);
                check[ans[i]] = true;
            }
            System.out.println();

            int sTeam = 0;
            //start team
            for(int i=1; i<=team; i++){
                int res = iAns & (1 << (i-1));
                if(res != 0){
                    for(int j=1; j<=team; j++){
                        if(i == j) continue;
                        int res2 = iAns & (1 << (j-1));
                        if(res2 != 0){
                            sTeam += aPower[i][j];
                        }
                    }
                }
            }
            int lTeam = 0;
            //link team
            for(int i=1; i<=team; i++){
                int res = iAns & (1 << (i-1));
                if(res == 0){
                    for(int j=1; j<=team; j++){
                        if(i == j) continue;
                        int res2 = iAns & (1 << (j-1));
                        if(res2 == 0){
                            lTeam += aPower[i][j];
                        }
                    }
                }
            }

            int diff = Math.abs(sTeam - lTeam);

            if(diff < min) min = diff;

        }else{
            for(int i=start; i<=total && team-index <= total-start+1; i++){
                ans[index] = i;
                iAns = iAns | (1 << (i-1));
                System.out.println(".."+iAns);
                check[i] = true;
                combination(index+1,i+1);
                check[i] = false;
                iAns = iAns &~ (1 << (i-1));
                System.out.println("..."+iAns);
            }
        }
    }

}
