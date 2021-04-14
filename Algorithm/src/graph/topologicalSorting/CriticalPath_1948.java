/*
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7
위상정렬을 두번 실행 해야한다.
첫번째 위상정렬 과정에서는 최대 시간을 구하고
두번째 위사정렬 과정에서는 최대 시간이 걸리는 간선의 개수를 찾아야 한다.
두번째 과정을 설명해보겠다.

u1 -> v
   c1
u2 -> v
   c2
u3 -> v
   c3

위와 같다고 하면
최대시간을 구할때
dist[v] = max(dist[u]+c) 이렇게 될것이다
이 식을 이용하면
c = dist[v] - dist[u] 이렇게 될것이다.

최대시간 구한 배열 = { 0, 4, 2, 3, 3, 7, 12}


기존 그래프를 뒤집에서 저장한다.
도착지에서 시작해 갈 수 있는 정점들을 조사한다.
테스트 케이스를 살펴보면
도착지는 7이거 7에서 갈 수 있는 곳은 2와 6이 있다.
7은 12, 2는 4이다 12-4=8 하지만 간선의 가중치는 5이다.
즉, 임계경로에 포함되지 않는다.
6은 7이다. 12-7=5 간선의 가중치 또한 5이다.
임계경로에 포함된다.
이때 간선과 함께 정점도 임계경로에 포함된다고 체크해야한다. 그 이유는 다음 상황을 살펴보자

위와 같은 과정을 반복하다가 5->3으로 가는 간선을 살펴보자
5는 임계경로에 포함 안된 정점이다
하지만 5의 거리 3, 3의 거리 2 둘의 차이와 간선의 가중치는 1로 같다.
하지만 임계경로에 포함할 수 없다. 왜냐하면 5가 임계경로에 포함 되지 않는 정점이기 때문이다.

위와 같은 과정을 해서 개수를 체크하면 된다.
*/
package graph.topologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Edge{
    int to, cost;
    Edge(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

public class CriticalPath_1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge>[] list = new ArrayList[n+1];
        ArrayList<Edge>[] list2 = new ArrayList[n+1];
        int[] ind = new int[n+1];
        int[] ind2 = new int[n+1];

        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list[from].add(new Edge(to, cost));
            list2[to].add(new Edge(from, cost));
            ind[to] += 1;
            ind2[from] += 1;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        //최대시간 구하기
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int cur = q.remove();
            for(int i=0; i<list[cur].size(); i++){
                Edge next = list[cur].get(i);
                ind[next.to] -= 1;
                dist[next.to] = Math.max(dist[next.to], (dist[cur]+next.cost));
                if(ind[next.to] == 0){
                    q.add(next.to);
                }
            }
        }

        //임계 경로 구하기
        int ans = 0;
        boolean[] check = new boolean[n+1];
        q = new LinkedList<>();
        q.add(end);
        check[end] = true;
        while (!q.isEmpty()){
            int cur = q.remove();
            for(int i=0; i<list2[cur].size(); i++){
                Edge next = list2[cur].get(i);
                ind2[next.to] -= 1;
                if(check[cur] && dist[cur]-dist[next.to] == next.cost){
                    ans += 1;
                    check[next.to] = true;
                }

                if(ind2[next.to] == 0){
                    q.add(next.to);
                }
            }
        }

        System.out.println(dist[end]);
        System.out.println(ans);

    }
}
