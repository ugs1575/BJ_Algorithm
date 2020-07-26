package bruteforce;

import java.util.Scanner;

public class PieceOfPaper_14391 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            String num = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = num.charAt(j)-'0';
            }
        }

        int ans = 0;
        // 0: -, 1 : |

        //전체 집합
        for(int s=0; s<(1 << (n*m)); s++){
            int sum = 0;
            //가로
            for(int i=0; i<n; i++){
                int cur = 0;
                for(int j=0; j<m; j++){
                    int k = i*m+j;
                    //가로 연속인 경우
                    if((s & 1<<k) == 0){
                        cur = cur * 10 + arr[i][j];
                    }else{ //세로인 경우
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur; //한 행이 모두 가로였던 경우 더하지 못하므로
            }

            //세로
            for(int j=0; j<m; j++){
                int cur = 0;
                for(int i=0; i<n; i++){
                    int k = i*m+j;
                    if((s & (1 << k)) != 0){
                        cur = cur * 10 + arr[i][j];
                    }else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            ans = Math.max(ans, sum);

        }

        System.out.println(ans);
    }


}
