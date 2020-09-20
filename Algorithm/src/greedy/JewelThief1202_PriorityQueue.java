/*
* 보석과 가방을 하나로 합치고 무게를 기준으로 오름차순 정렬하자
* (1,23), (2,99), 2, (5,65), 10
* 무게가 증가하는 순으로 정렬했기 때문에, 앞에 있는 모든 보석은 다 가방에 들어갈 수 있다.
* 보석의 경우에는 가격을 H에 저장하고
* 가방의 경우에는 H에서 가장 큰 값을 찾고, 제거한다.
* 이를 효율적츠로 할 수 있는 자료구조는 ? 최대힙
*
*
* */
package greedy;

import java.util.*;

class Jewel2 implements Comparable<Jewel2>{
    int m, v, w;
    Jewel2(int m, int v, int w){
        this.m = m;
        this.v = v;
        this.w = w; // 0 == 보석 , 1 == 가방
    }
    @Override
    public int compareTo(Jewel2 o) {
        if(this.m < o.m){ //보석 무게 오름차 순으로
            return -1;
        }else if(this.m == o.m){ //무게가 같으며 보석 먼저
            if(this.w < o.w) return -1;
            else if(this.w == o.w) return 0;
            else return 1;
        }else{
            return 1;
        }
    }
}

public class JewelThief1202_PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Jewel2[] a = new Jewel2[n+k];
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            a[i] = new Jewel2(m,v,0);
        }
        for(int i=0; i<k; i++){
            int m = sc.nextInt();
            a[n+i] = new Jewel2(m, 0,1);
        }
        Arrays.sort(a);
        // 가방에 담을 수 있는 보석을 우선순위큐에 담는다.
        // 우선순위 큐 : 최대힙을 통해 구현된 자료구조.시간복잡도 : O(logN)으로, 일반 array나 List를 정렬하는 것보다 빠르다(성능이 좋다).
        // 기본값은 오름차순이지만, 내림차순이 필요한 경우 -를 붙여서 저장한 후, 꺼내쓸 때 절댓값을 출력하는 Math.abs(int n)이용
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        long ans = 0;
        for(Jewel2 p : a){
            if(p.w == 0){
                q.offer(-p.v);
            }else{
                if(!q.isEmpty()){
                    ans += Math.abs(q.poll());
                }
            }
        }
        System.out.println(ans);
    }

}
