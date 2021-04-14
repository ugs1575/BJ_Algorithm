/*
    아래와 같은 경우 어떻게 바꿔도 결국 먹을 수 있는 최대 사탕의 수는 4개입니다.
    꼭 바꾼곳에서 최대사탕개수가 나온다고 보장할 수 없습니다

    4
    CCCC
    YDYD
    DYDY
    YDYD
*/

package bruteforce.etc;

import java.util.Scanner;

public class CandyGame_3085 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            char[] input = sc.next().toCharArray();
            for(int j=0; j<n; j++){
                arr[i][j] = input[j];
            }
        }


        int max = 0;

        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){

                if(y+1 < n){
                    //오른쪽 교환
                    arr = swap(arr, x, y, x, y+1);
                    int duplicate = findDplict(n, arr);
                    if(duplicate > max)
                        max = duplicate;
                    arr = swap(arr, x, y+1, x, y);
                }

                if(x+1 < n){
                    //아래 교환
                    arr = swap(arr, x, y, x+1, y);
                    int duplicate2 = findDplict(n, arr);
                    if(duplicate2 > max)
                        max = duplicate2;
                    arr = swap(arr, x+1, y, x, y);
                }

            }
        }

        System.out.println(max);
    }

    public static char[][] swap(char[][] a, int x1, int y1, int x2, int y2){
        char temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;

        return a;
    }

    public static int findDplict(int n, char[][] a){
        int max = 0;
        int duplicate = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(a[i][j] == a[i][j+1]){
                    duplicate+=1;
                }else{
                    duplicate = 1;
                }
                if(duplicate > max){
                    max = duplicate;
                }
            }

            duplicate = 1;

            for(int j=0; j<n-1; j++){
                if(a[j][i] == a[j+1][i]){
                    duplicate+=1;
                }else{
                    duplicate = 1;
                }
                if(duplicate > max){
                    max = duplicate;
                }
            }

            duplicate = 1;
        }


        return max;
    }
}
