/*
* 0분부터 12분까지 상황
* 분    0 1 2 3 4  5  6  7  8  9  10 11 12
* 기구1 1 6 7 9 11 14 16 19 20 23 25 28 29
* 기구2 2   8   12    17    21    26    30
* 기구3 3    10       18       24       31
* 기구4 4       13          22          32
* 기구5 5          15             27
*
* 8분까지 탄 학생의 수는 몇명인가?
* 5(0분에 탄 학생 5명 포함 안됨) + 8/1 + 8/2 + 8/3 + 8/4 + 8/5
* = 22명
* 8분에 탄 학생의 수는 몇명인가?
* 나누어 떨어지는것이 3번 있었으니까 3명, 20~22
* 8%1 == 0,  8%2 == 0,  8%4 ==0 -> 3명
* 8분에는 1번놀이기구에 1명이타고, 2번 놀이기구에 1명이타고, 4번 놀이기구에 한명이 탄것이다.
* 20번은 1번, 21번은 2번, 22번은 4번에 탐..
* */

package divideConquer.binarySearch;

import java.util.*;

public class Amusementpark_1561 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];

        for(int i=0; i<m; i++){
            a[i] = sc.nextInt();
        }

        if(n <= m){
            System.out.println(n);
            return;
        }

        long left = 0;
        long right = 2000000000L * 10000L * 30L;//20억사람 * 만개의 놀이기구 * 모든 놀이 기구 운영시간 30분
        while (left <= right){
            long mid = (left+right)/2;
            long end = m;
            long start = 0;
            for(int i=0; i<m; i++){
                end += mid/a[i];
            }
            start = end;
            for(int i=0; i<m; i++){
                if(mid%a[i] == 0){
                    start -= 1;
                }
            }

            start += 1;
            if(n < start){
                right = mid-1;
            }else if(n > end){
                left = mid+1;
            }else{
                for(int i=0; i<m; i++){
                    if(mid%a[i] == 0){
                        if(n == start){
                            System.out.println(i+1);
                            return;
                        }
                        start += 1;
                    }
                }
            }
        }
    }
}
