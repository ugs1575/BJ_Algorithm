package graph;

/*
* 만들어지는 수의 개수는 최대 10^9개이다 ? 아니다
* x -> x^2 또는 2xX의 형태로 변형만 가능하기 때문에 만들어지는 수는 X^a2^b 형태이다
* 어마어마하기 작게 나올것이
*
* 매번 방문점을 append 한 이유 -> 공간의 갯수가 많이 안필요 하기 때문에...
* */

import java.util.*;

public class FourOperation_14365 {
    final static long limit = 1000000000L;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long s = sc.nextInt();
        long t = sc.nextInt();
        Queue<Long> q = new LinkedList<Long>();
        Queue<String> qs = new LinkedList<String>();
        HashSet<Long> check = new HashSet<Long>(); //입력 크기가 커서 배열을 만들 수 없으므로 set 사용
        q.add(s);
        qs.add("");
        check.add(s);
        while (!q.isEmpty()){
            long x = q.remove();
            String str = qs.remove();
            if(x == t){
                if(str.length() == 0){
                    str = "0";
                }
                System.out.println(str);
                System.exit(0);
            }
            if(0 <= x*x && x*x <= limit && check.contains(x*x) == false){
                q.add(x*x);
                qs.add(str+"*");
                check.add(x*x);
            }
            if(0 <= x+x && x+x <= limit && check.contains(x+x) == false){
                q.add(x+x);
                qs.add(str+"+");
                check.add(x+x);
            }
            if(0 <= x-x && x-x <= limit && check.contains(x-x) == false){
                q.add(x-x);
                qs.add(str+"-");
                check.add(x-x);
            }
            if(x != 0 && 0 <= x/x && x/x <= limit && check.contains(x/x) == false){
                q.add(x/x);
                qs.add(str+"/");
                check.add(x/x);
            }
        }
        System.out.println(-1);

    }
}
