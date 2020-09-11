package graph;
/*
BFS에서 역추적할때는 모든 과정을 기록하면 안되고
마지막 한단계만 기록해서 역추적하는 과정을 거쳐야 한다.
dist[] -> 거리 저장
from[] -> 어디에서 왔는지
how[] -> 어떻게
*/
import java.util.*;

public class DSLR_9019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            boolean[] check = new boolean[10001];
            int[] dist = new int[10001];
            int[] from = new int[10001];
            char[] how = new char[10001];

            check[a] = true;
            dist[a] = 0;
            from[a] = -1;

            Queue<Integer> q = new LinkedList<>();

            q.add(a);
            while(!q.isEmpty()){
                int num = q.remove();

                //d
                int res = 2*num;
                if(res > 9999) res %= 10000;
                if(check[res] == false){
                    q.add(res);
                    check[res] = true;
                    dist[res] = dist[num]+1;
                    from[res] = num;
                    how[res] = 'D';
                }


                //s
                res = num-1;
                if(res == -1) res = 9999;
                if(check[res] == false){
                    q.add(res);
                    check[res] = true;
                    dist[res] = dist[num]+1;
                    from[res] = num;
                    how[res] = 'S';
                }


                //l
                res = (num%1000)*10 + num/1000;
                if(check[res] == false){
                    q.add(res);
                    check[res] = true;
                    dist[res] = dist[num]+1;
                    from[res] = num;
                    how[res] = 'L';
                }

                //r
                res = (num%10)*1000 + num/10;
                if(check[res] == false){
                    q.add(res);
                    check[res] = true;
                    dist[res] = dist[num]+1;
                    from[res] = num;
                    how[res] = 'R';
                }
            }

            StringBuilder ans = new StringBuilder();
            while (b != a){
                ans.append(how[b]);
                b = from[b];
            }
            System.out.println(ans.reverse());
        }

    }
}
