package greedy;

import java.util.Scanner;

public class RollerCoaster_2873 {
    public static void append(StringBuilder sb, char d, int cnt){
        for(int i=0; i<cnt; i++){
            sb.append(d);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                a[i][j] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        if(r%2 == 1){
            for(int i=0; i<r; i++){
                if(i%2 == 0){
                    append(sb, 'R', c-1);
                    if(i != r-1) append(sb,'D',1);
                }else{
                    append(sb, 'L', c-1);
                    append(sb,'D',1);
                }

            }
        }else if(c%2 == 1){
            for(int i=0; i<c; i++){
                if(i%2 == 0){
                    append(sb, 'D', r-1);
                    if(i != c-1) append(sb, 'R',1);
                }else{
                    append(sb, 'U', r-1);
                    append(sb, 'R',1);
                }

            }
        }else{
            StringBuilder sb2 = new StringBuilder();
            //첫번째 검은색으로 셋
            int x = 0;
            int y = 1;
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if((i+j)%2 == 1){ //검은색 중 최소값 = 방문하지 않을 칸 찾
                        if(a[x][y] > a[i][j]){
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            int x1 = 0;
            int y1 = 0;
            int x2 = r-1;
            int y2 = c-1;
            //A, B 행검사
            while (x2 - x1 > 1){
                if (x1/2 < x/2){
                    append(sb,'R',c-1 );
                    append(sb,'D',1);
                    append(sb, 'L',c-1);
                    append(sb,'D',1);
                    x1 += 2;
                }

                if(x/2 < x2/2){
                    append(sb2,'R',c-1);
                    append(sb2,'D',1);
                    append(sb2,'L',c-1);
                    append(sb2,'D',1);
                    x2 -= 2;
                }
            }
            //A, B 열검사
            while (y2 - y1 > 1){
                if(y1/2 < y/2){
                    append(sb,'D',1);
                    append(sb,'R',1);
                    append(sb,'U',1);
                    append(sb,'R',1);
                    y1 += 2;
                }
                if(y/2 < y2/2){
                    append(sb2,'D',1);
                    append(sb2,'R',1);
                    append(sb2,'U',1);
                    append(sb2,'R',1);
                    y2 -= 2;
                }
            }

            if(y == y1){
                append(sb,'R',1);
                append(sb,'D',1);
            }else{
                append(sb,'D',1);
                append(sb,'R',1);
            }
            sb2.reverse();
            sb.append(sb2);
        }

        System.out.println(sb);
    }
}
