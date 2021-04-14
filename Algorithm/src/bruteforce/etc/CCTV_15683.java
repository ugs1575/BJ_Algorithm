package bruteforce.etc;

import java.util.*;

class cctv{
    int x, y, type, dir;
    cctv(int x, int y, int type, int dir){
        this.x = x;
        this.y = y;
        this.type = type;
        this.dir = dir;
    }
}

public class CCTV_15683 {
    static int n, m;
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    static void check(int[][] a, int[][] b, int x, int y, int dir){
        int i = x;
        int j = y;
        while (0 <= i && i < n && 0 <= j && j < m){
            if(a[i][j] == 6) break;
            b[i][j] = a[x][y];
            i += dx[dir];
            j += dy[dir];
        }
    }
    static int go(int[][] a, ArrayList<cctv> list, int index){
        if(index == list.size()){
            int[][] b = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    b[i][j] = a[i][j];
                }
            }
            for(cctv c : list){
                int what = c.type;
                int x = c.x;
                int y = c.y;
                int dir = c.dir;
                if(what == 1){
                    check(a, b, x, y, dir);
                }else if(what == 2) { //항상 두방향이 2차이가 난다, 나머지 4는 dir이 3 이상이 되면 x
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+2)%4);
                }else if(what == 3){
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+1)%4);
                }else if(what == 4){
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+1)%4);
                    check(a, b, x, y, (dir+2)%4);
                }else if(what == 5){
                    check(a, b, x, y, dir);
                    check(a,b, x, y, (dir+1)%4);
                    check(a, b, x, y, (dir+2)%4);
                    check(a, b, x, y, (dir+3)%4);
                }
            }
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(b[i][j] == 0){
                        cnt += 1;
                    }
                }
            }
            return cnt;
        }
        int ans = n*m;
        for(int i=0; i<4; i++){
            list.get(index).dir = i;
            int temp = go(a, list, index+1);
            if(ans > temp){
                ans = temp;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] office = new int[n][m];

        ArrayList<cctv> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                office[i][j] = sc.nextInt();
                if(office[i][j] >= 1 && office[i][j] <= 5){
                    list.add(new cctv(i, j, office[i][j], 0));
                }
            }
        }

        System.out.println(go(office, list, 0));


    }


}
