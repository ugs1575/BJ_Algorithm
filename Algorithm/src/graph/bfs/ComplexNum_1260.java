package graph.bfs;

import java.util.*;

public class ComplexNum_1260 {
    static int[][] house;
    static int[][] check;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine();
        house = new int[n][n];
        check = new int[n][n];
        for(int line=0; line<n; line++){
            String oneLine = sc.nextLine();
            char[] aLine = oneLine.toCharArray();
            for(int c=0; c<n; c++){
                house[line][c] = Character.getNumericValue(aLine[c]);
            }
        }

        ArrayList<Integer> aList = new ArrayList<Integer>();
        int cNum = 1;
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(house[x][y] == 1 && check[x][y] == 0){
                    int ans = bfs(x, y, n, cNum);
                    aList.add(ans);
                    cNum++;
                }
            }
        }

        System.out.println(cNum-1);
        Collections.sort(aList);
        for(int value : aList){
            System.out.println(value);
        }

        //테스트
        /*for(int x=0; x<n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(check[x][y]);
            }
            System.out.println();
        }*/
    }

    public static int bfs(int x, int y, int n, int cNum){
        int cnt = 1;
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        check[x][y] = cNum;
        qx.add(x);
        qy.add(y);
        while (!qx.isEmpty() && !qy.isEmpty()){
            x = qx.peek();
            y = qy.peek();
            //상
            if(x-1 >= 0){
                if(house[x-1][y] == 1 && check[x-1][y] == 0){
                    check[x-1][y] = cNum;
                    cnt++;
                    qx.add(x-1);
                    qy.add(y);
                }
            }

            //하
            if(x+1 < n){
                if(house[x+1][y] == 1 && check[x+1][y] == 0){
                    check[x+1][y] = cNum;
                    cnt++;
                    qx.add(x+1);
                    qy.add(y);
                }
            }

            //좌
            if(y-1 >= 0){
                if(house[x][y-1] == 1 && check[x][y-1] == 0){
                    check[x][y-1] = cNum;
                    cnt++;
                    qx.add(x);
                    qy.add(y-1);
                }
            }

            //우
            if(y+1 < n){
                if(house[x][y+1] == 1 && check[x][y+1] == 0){
                    check[x][y+1] = cNum;
                    cnt++;
                    qx.add(x);
                    qy.add(y+1);
                }
            }

            qx.remove();
            qy.remove();

        }
        return cnt;
    }
}
