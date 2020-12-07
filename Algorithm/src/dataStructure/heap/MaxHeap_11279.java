package dataStructure.heap;

import java.util.*;

public class MaxHeap_11279 {
    static class Compare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(1, cmp);
        while (n-- > 0){
            int num = sc.nextInt();
            if(num == 0){
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                q.offer(num);
            }
        }
    }
}
