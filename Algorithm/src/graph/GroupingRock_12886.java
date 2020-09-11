/*
boolean 형을 잘못생각하면 1000 1000 1000 구조로 해야하나 생각 할수 있다.
이렇게 제출하면 메모리초과 오류를 발생시킨다.
따라서 문제를 자세히보면 a b c 의 총량은 항상 일정하다는것을 알수있다.
따라서 2개의 값이정해지면 나머지하나의 값은 전체에서 두개를 빼주는 아이디어로 메로리초과를 방지할수가있다.
*/
package graph;

import java.util.*;

public class GroupingRock_12886 {
    public static int sum = 0;
    public static boolean[][] check = new boolean[1501][1501];
    public static void go(int x, int y){
        if(check[x][y]) return;
        check[x][y] = true;
        int[] a = {x, y, sum-x-y};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(a[i] < a[j]){
                    int[] b = {x, y, sum-x-y};
                    b[i] += a[i];
                    b[j] -= a[i];
                    go(b[0], b[1]);
                }
            }
        }
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sum = a+b+c;
        if(sum%3 != 0){
            System.out.println(0);
            System.exit(0);
        }
        go(a, b);
        if(check[sum/3][sum/3]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}
