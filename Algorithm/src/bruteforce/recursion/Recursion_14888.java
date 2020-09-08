/*
* 크게 생각을 해보면
* 1. 첫 시작에 index 1을 넣어주는 이유
* a: 입력으로 주어진 수열
* index : 현재 계산해야 하는 인덱스
* cur : index-1번째까지 계산한 결과
* plus, minus, mul, div : 사용할 수 있는 연산자의 개수
* a[index]의 이전에 오는 연산자를 구해야함
* 2. 전체적인 프로세스
* index == n 되었을때 계산한 pair 값을 return 해서 res 에 넣어줌
* 재귀로 호출해서 모두 구했을때 마지막에는 모든 경우의 수의 결과값들이 res에 들어간다
* 마지막 for문을 돌려 최댓값과 최솟값을 구해 return
*
* */

package bruteforce.recursion;

import java.util.ArrayList;
import java.util.Scanner;

class Pair{
    public int min, max;
    Pair(int min, int max){
        this.min = min;
        this.max = max;
    }
}

public class Recursion_14888 {
    static Pair calc(int[] a, int index, int cur, int plus, int minus, int mul, int div){
        int n = a.length;
        if(index == n){
            return new Pair(cur, cur);
        }

        ArrayList<Pair> res = new ArrayList<>();
        if(plus > 0){
            res.add(calc(a, index+1, cur+a[index], plus-1, minus, mul, div));
        }
        if(minus > 0){
            res.add(calc(a, index+1, cur-a[index], plus, minus-1, mul, div));
        }
        if(mul > 0){
            res.add(calc(a, index+1, cur*a[index], plus, minus, mul-1, div));
        }
        if(div > 0){
            res.add(calc(a, index+1, cur/a[index], plus, minus, mul, div-1));
        }

        Pair ans = res.get(0);
        for(Pair p : res){
            if(ans.max < p.max){
                ans.max = p.max;
            }
            if(ans.min > p.min){
                ans.min = p.min;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        Pair ans = calc(a, 1, a[0], plus, minus, mul, div);

        System.out.println(ans.max);
        System.out.println(ans.min);
    }
}


