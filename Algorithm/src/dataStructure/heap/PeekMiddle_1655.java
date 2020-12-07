/*
* 수를 N/2, N/2개로 나눠서 왼쪽과 오른쪽으로 나눠서 푼다.
* 왼쪽 : 최대힙
* 오른쪽 : 최소힙
*
* 다음 조건을 항상 만족 해야 한다.
* 왼쪽 <= 오른쪽
* 항상 왼쪽과 오른쪽 크기의 차이를 1보다 작거나 같게 만든다.
* 홀수일 경우 왼쪽이 오른쪽보다 1개가 많다.
*
* */
package dataStructure.heap;

import java.util.*;

class Compare implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

public class PeekMiddle_1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Compare cmp = new Compare();
        PriorityQueue<Integer> l = new PriorityQueue<>(1, cmp);
        PriorityQueue<Integer> r = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            if(l.isEmpty() || r.isEmpty()){
                l.add(x);
            }else{
                if(x >= l.peek()){
                    r.add(x);
                }else{
                    l.add(x);
                }
            }
            while (!(l.size() == r.size() || l.size() == r.size()+1)){
                if(l.size() > r.size()){
                    r.add(l.peek());
                    l.poll();
                }else{
                    l.add(r.peek());
                    r.poll();
                }
            }
            System.out.println(l.peek());

        }
    }
}
