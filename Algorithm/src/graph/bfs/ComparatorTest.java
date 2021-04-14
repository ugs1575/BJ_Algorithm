package graph.bfs;/*order의 인덱스를 aList의 숫자 order의 value값을 순서라고 생각하고
이값을 기준으로 aList값이 정렬된다.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String args[]){
        //0:3, 1:1, 2:0, 3:2
        int[] order = {3,1,0,2};
        ArrayList<Integer> aList = new ArrayList<Integer>();
        aList.add(0);
        aList.add(1);
        aList.add(2);
        aList.add(3);

        Collections.sort(aList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(order[o1] < order[o2]){
                    return -1;
                }else if(order[o1] == order[o2]){
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        for(int i=0; i<aList.size(); i++){
            System.out.print(aList.get(i)+" ");
        }
    }
}
