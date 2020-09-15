package graph;

import java.util.*;

public class PathOfPrime_1963 {
    //num의 index번째를 digit으로 바꾼다
    public static int change(int num, int  index, int digit){
        if(index == 0 && digit == 0){
            return -1;
        }
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        //index번째를 char로 바꿈, returns nothing
        sb.setCharAt(index, (char)(digit + '0'));
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 에라토스테네스의 체를 이용해 10000미만의 소수들을 먼저 검사한다.
        boolean[] prime = new boolean[10001];
        for(int i=2; i<=10000; i++){
            if(prime[i] == false){
                for(int j=i*i; j<=10000; j+=i){
                    prime[j] = true;
                }
            }
        }
        //소수인게 false 여서 바꾸준다
        for(int i=0; i<=10000; i++){
            prime[i] = !prime[i];
        }
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[] c = new boolean[10001];
            int[] d = new int[10001];
            d[n] = 0;
            c[n] = true;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(n);
            while (!q.isEmpty()){
                int now = q.remove();
                for(int i=0; i<4; i++){ //i번째 자리를 j로 바꾼다
                    for(int j=0; j<=9; j++){
                        int next = change(now, i, j);
                        if(next != -1){
                            if(prime[next] && c[next] == false){
                                q.add(next);
                                d[next] = d[now]+1;
                                c[next] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(d[m]);
        }
    }
}
