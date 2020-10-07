/*
* 1부터 N까지의 수를 한번씩 이용해서 최대 부분 증가 수열의 길이가 m이고, 최대 부분 감소 수열의 길이가 k인 수열을 구하는 문제
*
*
* 적어도 m개의 정수는 증가 수열에 포함되어야하고
* 적어도 K개의 정수는 감소 수열에 포함되어야한다.
* 두 수열은 최대 정수 1개를 공유 할 수 있기 때문에
* n >= m+k-1 이어야한다.
* 또 n은 mk를 넘을 수 없다.
* n = mk + 1인 경우에 길이가 m+1인 증가 수열이나 길이가 k+1인 감소수열을 반드시 만들 수 있다.
*   예를 들어 모든 그룹을 k개로 만들어보자, 그룹도 k, 각 그룹 갯수도 k
*   이상태에서 한개를 추가하면 길이가 m+1인 증가수열 k+1인 감소수열을 반드시 만들 수 있다.
* m+k-1 <= n <= mk 인 경우에만 답을 찾을 수 있다.
*
* <풀이>
* 1. 1부터 n까지 수를 오름차순으로 적는다
* 2. 수를 m등분한다. 이때, 그룹에 들어있는 수는 k보다 작거나 같아야하며
*    적어도 한 그룹은 들어잇는 수의 개수가 k이어야 한다.
* 3. 각 그룹에 들어있는 수의 순서를 뒤집는다
*
* <예제>
* - N=13, M=5, K=4 인경우
* 1. 1 2 3 4 5 6 7 8 9 10 11 12 13
* 적어도 한 그룹은 k개가 되어야하니까 처음부터 k로 나눈다
* 나머지는 n-k/m-1 나머지가 0이상이면 한개씩 그룹에 넣어줌
* 2. 1 2 3 4 | 5 6 7 | 8 9 | 10 11 | 12 13
* 3. 4 3 2 1 | 7 6 5 | 9 8 | 11 10 | 13 12
* 각 그룹에서 한개씩 빼면 가장 긴 증가하는 부분수열이 되고
* 첫번째 그룹(원소 갯수가 k개인 그룹)은 가장 긴 감소하는 부분수열이 된다.
*
*
* */

package greedy;

import java.util.*;

public class NMK_1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        if(m+k-1 <= n && n <= m*k){
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = i+1;
            }

            ArrayList<Integer> group = new ArrayList<>();
            group.add(0);
            group.add(k);
            m -= 1;
            n -= k;
            int group_size = m == 0 ? 1 : n/m;
            int r = m == 0 ? 0 : n%m;
            for(int i=0; i<m; i++){
                group.add(group.get(group.size()-1)+group_size+(r > 0 ? 1 : 0));
                if(r > 0){
                    r -= 1;
                }
            }


            for(int i=0; i<group.size()-1; i++){
                int begin = group.get(i);
                int end   = group.get(i+1)-1;
                while (begin < end){
                    int temp = a[begin];
                    a[begin] = a[end];
                    a[end] = temp;
                    begin += 1;
                    end -= 1;
                }
            }

            for(int i=0; i<a.length; i++){
                System.out.print(a[i]+" ");
            }

        }else{
            System.out.println(-1);
        }


    }
}
