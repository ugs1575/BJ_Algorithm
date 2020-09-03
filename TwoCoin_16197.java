package bruteforce.recursion;

import java.util.Scanner;

public class TwoCoin_16197 {
    static int n, m, x1, y1, x2, y2;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] arr;
    //static boolean find;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n   = sc.nextInt();
        m   = sc.nextInt();
        arr = new char[n][m];

        boolean count = false;
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'o'){
                    if(!count){
                        x1 = i;
                        y1 = j;
                        count = true;
                    }else{
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        System.out.println(go(x1, y1, x2, y2, 0));

        /*if(!find){
            min = -1;
        }
        System.out.println(min);
        */


    }

    public static int go(int x1, int y1, int x2, int y2, int push){
        //System.out.println("x1 : "+x1+" / y1 : "+y1+" / x2 : "+x2+" / y2 : "+y2+" / push : "+push+" / find : "+find);
        //10보다 많이 눌러야하는 경우
        if(push > 10){
            return -1;
        }

        //둘다 떨어뜨린 경우
        if(isOut(x1, y1) && isOut(x2, y2)){
            return -1;
        }

        //정답을 찾은 경우 : 한개의 구슬만 떨어뜨린경우
        if(isOut(x1, y1) && !isOut(x2, y2) || !isOut(x1, y1) && isOut(x2, y2)){
            return push;
        }

        //둘다 벽인 경우
        if(arr[x1][y1] == '#' && arr[x2][y2] == '#'){
            return -1;
        }

        int ans = -1;

        for(int i=0; i<4; i++){
            int nextX1 = x1+dx[i];
            int nextY1 = y1+dy[i];
            int nextX2 = x2+dx[i];
            int nextY2 = y2+dy[i];

            if(!isOut(nextX1, nextY1) && arr[nextX1][nextY1] == '#'){
                nextX1 = x1;
                nextY1 = y1;
            }

            if(!isOut(nextX2, nextY2) && arr[nextX2][nextY2] == '#'){
                nextX2 = x2;
                nextY2 = y2;
            }

            int temp = go(nextX1, nextY1, nextX2, nextY2, push+1);
            if(temp == -1) continue;
            if(ans == -1 || ans > temp){
                ans = temp;
            }
        }

        return ans;
    }

    //해당 위치가 범위 밖인지 체크하는 함수
    public static boolean isOut(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return true;
        }else{
            return false;
        }
    }
}
