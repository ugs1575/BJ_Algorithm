package bruteforce;

import java.util.Scanner;

public class ItalyIcecream_2422 {
    static int n, m;
    static boolean[][] check;
    static int go(int start, int end, int index, int[] ans){
        int res = 0;
        if(index == 3){
            if(check[ans[0]][ans[1]] || check[ans[0]][ans[2]] || check[ans[1]][ans[2]]) return 0;
            else return 1;
        }

        for(int i=start; i<=end; i++){
            ans[index] = i;
            res += go(i+1, end, index+1, ans);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[201][201];
        for(int i=0; i<m; i++){
            int type1 = sc.nextInt();
            int type2 = sc.nextInt();
            check[type1][type2] = true;
            check[type2][type1] = true;
        }

        int[] ans = new int[3];

        System.out.println(go(1, n, 0, ans));
    }
}
