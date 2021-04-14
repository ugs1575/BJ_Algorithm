package bruteforce.etc;

/*
 총 경우의 수는 15 * 28 * 19 = 7890개로 무한 루프를 돌려도 1초 안에 풀수있는 문제이다
 나머지 연산으로 풀수 있는 문제 인줄 알았는데 마지막 테스트케이스를 간과했다
 e = 15, s = 28, e = 19 일때, 나머지 연산을 하면 나머지가 0이 나오기 때문에
 입력받은 수에서 1을 빼주고, 답을 출력할때는 +1을 해줘야 예외 처리를 할 수 있다
 */

import java.util.*;

public class DatesCal_1476 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt()-1;
        int s = sc.nextInt()-1;
        int m = sc.nextInt()-1;
        /*int year = 0;

        while(true){
            if(year % 15 == e && year % 28 == s && year % 19 == m ){
                break;
            }
            year ++;
        }

        System.out.println(year+1);*/

        //백준코드
        for(int i=0;; i++){
            if(i % 15 == e && i% 28 == s && i% 19 == m){
                System.out.println(i+1);
                break;
            }
        }
    }

}
