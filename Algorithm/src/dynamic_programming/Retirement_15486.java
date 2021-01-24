/*
* 그날 상담을 했을 때와 안했을 때로 구분한다.
* D[i] : i일 까지 상담 했을 때 최대수익
*
* */


package dynamicProgramming;

import java.util.*;
import java.io.*;

public class Retirement_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        int[] d = new int[n+50];
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }

        for(int i=0; i<n; i++){
            //i일에 있는 상담을 하는 경우
            //i+t[i]일이 된다
            //수익은 p[i]이 늘어난다
            d[i+t[i]] = Math.max(d[i+t[i]], d[i]+p[i]);
            //i일에 있는 상담을 하지 않는 경우
            //i+1일이 된다.
            //수익은 그대로이다.
            d[i+1] = Math.max(d[i+1], d[i]);
        }

        System.out.println(d[n]);


    }
}
