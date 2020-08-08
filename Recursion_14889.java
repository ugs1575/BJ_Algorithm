package bruteforce.recursion;

import java.util.Scanner;

public class Recursion_14889 {
    static int n, max, min;
    static int[][] arr;
    static boolean[] check;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n     = sc.nextInt();
        arr   = new int[n][n];
        check = new boolean[n];
        max   = n/2;
        min   = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        assignTeam(0, 0, true);

        System.out.println(min);
    }

    public static void assignTeam(int index, int cnt, boolean team){
        if(index >= n || cnt >= max){
            return;
        }

        if(team){
            check[index] = true;
        }else{
            check[index] = false;
        }

        if(cnt == max-1){
            int d = getDiff();
            if(d < min) min = d;
            return;
        }

        assignTeam(index+1, cnt+1, true);
        assignTeam(index+1, cnt, false);
    }


    public static int getDiff(){
        int startPower = 0;
        int linkPower  = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(check[i] && check[j]){
                    startPower += arr[i][j];
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(!check[i] && !check[j]){
                    linkPower += arr[i][j];
                }
            }
        }

        int ans = Math.abs(startPower - linkPower);

        return ans;
    }
}
