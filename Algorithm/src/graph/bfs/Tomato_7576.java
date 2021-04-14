package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato_7576 {
    static int x;
    static int y;
    static int[][] box;
    static int[][] check;
    static Queue<Integer> qx;
    static Queue<Integer> qy;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        box = new int[x][y];
        check = new int[x][y];
        qx = new LinkedList<>();
        qy = new LinkedList<>();
        int zero = 0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                int num = sc.nextInt();
                box[i][j] = num;
                if(num == 0){
                    zero++;
                }else if(num == 1){
                    qx.add(i);
                    qy.add(j);
                    check[i][j] = 1;
                }else if(num == -1){
                    check[i][j] = -1;
                }
            }
        }

        if(zero == 0){
            System.out.println(0);
        }else{
            boolean stop = false;
            int max = 0;
            bfs();
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    System.out.print(check[i][j]+" ");
                    if(check[i][j] == 0){
                        stop = true;
                        break;
                    }else{
                        if(check[i][j]>max){
                            max = check[i][j];
                        }
                    }
                }
                if(stop){
                    break;
                }
                System.out.println();
            }

            if(stop){
                System.out.println(-1);
            }else{
                System.out.println(max-1);
            }
        }


    }
    public static void bfs(){
        while(!qx.isEmpty() && !qy.isEmpty()){
            int length = qx.size();
            for(int i=0; i<length; i++){
                int row = qx.peek();
                int col = qy.peek();
                //상
                if(row-1 >= 0 && check[row-1][col] == 0 && box[row-1][col] == 0){
                    check[row-1][col] = check[row][col]+1;
                    qx.add(row-1);
                    qy.add(col);
                }
                //하
                if(row+1 < x && check[row+1][col] == 0 && box[row+1][col] == 0){
                    check[row+1][col] = check[row][col]+1;
                    qx.add(row+1);
                    qy.add(col);
                }
                //좌
                if(col-1 >= 0 && check[row][col-1] == 0 && box[row][col-1] == 0){
                    check[row][col-1] = check[row][col]+1;
                    qx.add(row);
                    qy.add(col-1);
                }
                //우
                if(col+1 < y && check[row][col+1] == 0 && box[row][col+1] == 0){
                    check[row][col+1] = check[row][col]+1;
                    qx.add(row);
                    qy.add(col+1);
                }

                qx.remove();
                qy.remove();
            }
        }
    }
}
