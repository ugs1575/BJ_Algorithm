package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;


class cross{
    int x, y, size;
    cross(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
public class FinidingCross2_17085 {
    static int n, m;
    static char[][] a;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean canDraw(boolean[][] check, int x, int y, int size){
        if(size == 0) {
            if(check[x][y]) return false;
            check[x][y] = true;
            return true;
        }
        boolean ok = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i]*size;
            int ny = y+dy[i]*size;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                ok = false;
                break;
            }
            if(a[nx][ny] != '#'){
                ok = false;
                break;
            }
            if(check[nx][ny]){
                ok = false;
                break;
            }

            check[nx][ny] = true;
        }

        return ok;
    }
    static void copy_array(boolean[][] check, boolean[][] temp){
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                temp[row][col] = check[row][col];
            }
        }
    }
    static void print_array(boolean[][] check){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i][j]){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println("************************");
    }
    static int getMaxArea(int[] ans, ArrayList<cross> list){
        int max = 0;
        cross a = list.get(ans[0]);
        cross b = list.get(ans[1]);
        System.out.println(a.x+"/"+a.y+"/"+a.size);
        System.out.println(b.x+"/"+b.y+"/"+b.size);
        boolean[][] temp = new boolean[n][m];
        for(int i=0; i<=a.size; i++){
            boolean[][] check = new boolean[n][m];
            copy_array(temp, check);
            print_array(temp);
            canDraw(check, a.x, a.y, i);
            copy_array(check, temp);
            for(int j=0; j<=b.size; j++){
                if(canDraw(check, b.x, b.y, j)){
                    int res = (i*4+1)*(j*4+1);
                    System.out.println("i : "+i+"j : "+j+" pass"+res);
                    max = Math.max(res, max);
                    //print_array(check);
                }else{
                    break;
                }
            }
        }

        return max;
    }
    static int pickTwo(int start, int end, int[] ans, int index, ArrayList<cross> list){
        int max = 0;
        if(index == 2){
            return getMaxArea(ans, list);
        }

        for(int i=start; i<=end; i++){
            ans[index] = i;
            int res = pickTwo(i+1, end, ans, index+1, list);
            max = Math.max(max, res);
        }

        return max;
    }
    static int findingCross(int x, int y){
        int size = 0;
        while (true){
            size += 1;
            boolean ok = true;
            for(int i=0; i<4; i++){
                int nx = x+dx[i]*size;
                int ny = y+dy[i]*size;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    ok = false;
                    break;
                }
                if(a[nx][ny] != '#'){
                    ok = false;
                    break;
                }
            }

            if(!ok){
                size -= 1;
                break;
            }
        }

        return size;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j);
            }
        }

        ArrayList<cross> list = new ArrayList<>();
        // #찾고 최대 십자기 크기 체크
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == '#'){
                    int s = findingCross(i, j);
                    list.add(new cross(i, j, s));
                }
            }
        }

        /*for(cross c : list){
            System.out.println(c.x+"/"+c.y+"/"+c.size);
        }*/

        int[] ans = new int[2];
        // 모든 경우의 수
        System.out.println(pickTwo(0, list.size()-1, ans, 0, list));

    }
}
