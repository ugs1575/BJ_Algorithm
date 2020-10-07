/*
* 예를 들어 수열 {1, 3, 1, 2, 4, 3, 4, 2}이 주어진다고 하자
* alist안 숫자보다 크면 넣어주고 아니면 이분탐색을 통해 바꿔줄 위치를 찾는다
* alist 오름차 순으로 정렬됨
* alist에 첫번째 요소 그냥 넣어줌
* 그 다음 3, 가장 마지막 요소와 비교해서 크니까 그냥 넣어줌
* 1 작으니까 이분탐색 alist(0)와 같으므로 바꿔줌..
* 이분탐색을 통해 해당 숫자보다 크거나 같은 수중 가장 작은 숫자의 인덱스를 가져와 수를 바꿔 준다
* 시간복잡도 : nlogn (이분탐색 logN 을 모든 숫자에 해줘야하기 때문에 N * logN
*
* */

package greedy;

import java.util.*;

public class LIS2_12015 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(a[0]);
        for(int i=1; i<n; i++){
            if(a[i] > alist.get(alist.size()-1)) alist.add(a[i]);
            else{
                int left = 0;
                int right = alist.size()-1;
                while (left < right){
                    int mid = (left+right)/2;
                    if(alist.get(mid) >= a[i]){
                        right = mid;
                    }else{
                        left = mid+1;
                    }
                }
                alist.set(right, a[i]);
            }
        }
        System.out.println(alist.size());
    }
}
