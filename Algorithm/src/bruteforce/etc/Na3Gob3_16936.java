/*
* 훨씬 간단하게 풀 수 있었다
* 문제의 조건에서 나3을 할 때는 무조건 3으로 나누어 떨어져야한다고 했다
* 예를 들어 4 8 6 3 12 9가 주어졌을 때
* 4 = 2^2
* 8 = 2^3
* 6 = 2*3
* 3 = 3
* 12 = 3*2^2
* 9 = 3^2
* 3으로 나누어 떨어지는 것중에 3으로 가장 많이 나눌 수 있는 것이 가장 처음 와야한다
* 아니면 나머지는
*
* */


package bruteforce.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Na3Gob3_16936 {
    static int n;
    static void print_a(int index, long[] b, ArrayList<Long>[] list, int cnt, StringBuilder sb){
        sb.append(b[index]+" ");

        if(cnt == n){
            System.out.println(sb);
            System.exit(0);
        }

        for(int i=0; i<list[index].size(); i++){
            long next = list[index].get(i);
            for(int j=0; j<n; j++){
                if(b[j] == next){
                    print_a(j, b, list, cnt+1, sb);
                }
            }
        }

        return;
    }
    static boolean check(long[] b, long num){
        int left = 0;
        int right = n-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(b[mid] == num){
                return true;
            }else{
                if(num < b[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }

       return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long[] b = new long[n];
        ArrayList<Long>[] list = new ArrayList[n];

        for(int i=0; i<n; i++){
            b[i] = sc.nextLong();
            list[i] = new ArrayList<Long>();
        }

        Arrays.sort(b);

        for(int i=0; i<n; i++){
            if(b[i]%3 == 0){
                long divide = b[i]/3;
                if(check(b, divide)){
                    list[i].add(divide);
                }
            }
            long multi = b[i]*2;
            if(check(b, multi)){
                list[i].add(multi);
            }
        }


        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            print_a(i, b, list, 1, sb);
        }

    }
}
