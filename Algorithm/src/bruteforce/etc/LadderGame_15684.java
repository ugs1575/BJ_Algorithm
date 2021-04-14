package bruteforce.etc;

import java.util.ArrayList;
import java.util.Scanner;

class Pair7{
    int x, y;
    Pair7(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class LadderGame_15684 {
    static int n, m, h;
    static boolean[][] a;
    static boolean checkRange(int x, int y){
        if(a[x][y]) return false;
        if(y-1 >= 0){
            if(a[x][y-1]) return false;
        }
        if(y+1 < n){
            if(a[x][y+1]) return false;
        }

        return true;
    }
    static boolean playGame(){
        for(int col=0; col<n; col++){
            int x = 0;
            int y = col;
            while (true){
                //System.out.println("play"+x+"/"+y);
                //아래로
                x+=1;
                if(a[x][y]){
                    //System.out.println("true"+x+"/"+y);
                    //사다리 타
                    y+=1;
                }else{
                    if(y-1 >= 0){
                        if(a[x][y-1]){
                            y -= 1;
                        }
                    }
                }
                if(x == h) break;
            }
            //System.out.println("&&&&&&&&&&&");

            if(y != col) return false;
        }

        return true;
    }
    static boolean canAdd(ArrayList<Pair7> list, int[] ans){
        boolean ok = true;
        for(int i=0; i<ans.length; i++){
            Pair7 p = list.get(ans[i]);
            if(checkRange(p.x, p.y)){
                a[p.x][p.y] = true;
            }else{
                ok = false;
                break;

            }
        }

        //원상복구..
        if(!ok){
            for(int i=0; i<ans.length; i++){
                Pair7 p = list.get(ans[i]);
                a[p.x][p.y] = false;
            }
        }

        return ok;
    }
    static boolean addLine(int start, int end, ArrayList<Pair7> list, int[] ans, int index){
        boolean win = false;
        if(index == ans.length){
            /*for(int i:ans){
                //System.out.println(i);
                Pair7 p = list.get(i);
                System.out.println(p.x+"/"+p.y);
            }*/
            boolean res = false;
            if(canAdd(list, ans)){
                //System.out.println("can add !");
                res = playGame();
                //System.out.println("result : "+res);
                //원상복구
                for(int i=0; i<ans.length; i++){
                    Pair7 p = list.get(ans[i]);
                    a[p.x][p.y] = false;
                }
            }
            //else{
                //System.out.println("can not add ");
            //}

            //System.out.println("***********");

            return res;
        }

        for(int i=start; i<=end; i++){
            ans[index] = i;
            boolean res = addLine(i+1, end, list, ans, index+1);
            if(res) win = true;
        }

        return win;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        a = new boolean[h+1][n];
        for(int i=0; i<m; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            a[row][col-1] = true;
        }
        ArrayList<Pair7> list = new ArrayList<>();
        for(int i=1; i<=h; i++){
            for(int j=0; j<n-1; j++){
                if(!checkRange(i, j)) continue;
                list.add(new Pair7(i,j));
            }
        }


        for(int i=0; i<=3; i++){
            int[] ans = new int[i];
            boolean res = addLine(0, list.size()-1, list, ans, 0);
            if(res){
                System.out.println(i);
                System.exit(0);
            }
        }

        System.out.println(-1);


    }
}
