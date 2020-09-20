/*
* 가격이 높은 보석부터 차례대로 각 보석을 담을 수 있는 가방 중 c[i]가 가장 작은 가방에 넣는다.
* 이를 구현하기 위해서는 다음을 효율적으로 할 수 있는 자료구조가 필요
* 1. 어떤 수 x보다 큰 숫자 중에 가장 작은 수를 찾는다. (Lower Bound)
* 2. 수를 지운다.
* 배열을 사용한다면 1은 O(lgK)에 할 수 있지만, 2를 O(K)에 할 수 있다.
* BST(Binary Search Tree)를 사용한다면 1과 2를 O(lgK)에 할 수 있다.
* + BST 설명 : 기준 노드에서 왼쪽에는 자신보다 작은 child node 오른쪽에는 자신 보다 큰 child node를 놓는다
*
* */

package greedy;

import java.util.*;

class Jewel implements Comparable<Jewel>{
    int m, v;
    Jewel(int m, int v){
        this.m = m;
        this.v = v;
    }


    @Override
    public int compareTo(Jewel o) {
        if(this.v > o.v){
            return -1;
        }else if(this.v == o.v){
            return 0;
        }else{
            return 1;
        }
    }
}

public class JewelThief1202_TreeMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Jewel[] j = new Jewel[n];
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            j[i] = new Jewel(m, v);
        }
        Arrays.sort(j); // 보석 무게가 큰 순으로 정렬
        //(가방 무게, 해당 무게를 가진 가방 개수) pair 저장
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for(int i=0; i<k; i++){
            int c = sc.nextInt();
            Integer val = d.get(c);
            if(val == null){
                val = 0;
            }
            val += 1;
            d.put(c, val);
        }
        long ans = 0;
        for(int i=0; i<n; i++){
            //보석 차례로 가능한 가방 찾기
            //찾으면 갯수 한개 줄이기
            // 줄이다 0이 되면 없애기
            Map.Entry<Integer, Integer> it = d.ceilingEntry(j[i].m);
            if(it != null){
                ans += j[i].v;
                int c = (int)it.getKey();
                Integer val = it.getValue() - 1;
                if(val == 0){
                    d.remove(c);
                }else{
                    d.put(c,val);
                }
            }
        }
        System.out.println(ans);

    }
}
