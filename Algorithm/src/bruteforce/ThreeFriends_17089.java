package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreeFriends_17089 {
    static int n, m;
    static boolean[][] check = new boolean[4000][4000];
    static ArrayList<Integer>[] alist;
    static int combination(int start, int end, int[] a, int index){
        int ans = -1;
        if(index == 3){
            if(check[a[0]][a[1]] && check[a[0]][a[2]] && check[a[1]][a[2]]) {
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    sum += alist[a[i]].size();
                    sum -= 2;
                }
                return sum;
            }

            return -1;

        }

        for(int i=start; i<=end; i++){
            boolean ok = true;
            if(index != 0){
                for(int j=index-1; j>=0; j--){
                    if(!check[i][a[j]]){
                        ok = false;
                        break;
                    }
                }
            }

            if(!ok) continue;

            a[index] = i;
            int res = combination(i+1, end, a, index+1);
            if(res != -1){
                if(ans == -1){
                    ans = res;
                }else if(res < ans){
                    ans = res;
                }
            }



        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        alist = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            alist[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            check[a][b] = true;
            check[b][a] = true;
            alist[a].add(b);
            alist[b].add(a);
        }

        int[] a = new int[3];
        System.out.println(combination(1, n, a, 0));
    }
}
