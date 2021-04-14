package programmers;

import java.util.*;

class Document {
    int l, p;
    Document(int l, int p){
        this.l = l;
        this.p = p;
    }

}

public class Printer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int location = sc.nextInt();
            int[] priorities = new int[n];
            for(int i=0; i<n; i++){
                int x = sc.nextInt();
                priorities[i] = x;
            }

            int[] cnt = new int[10];
            Queue<Document> q = new LinkedList<>();

            int max = 0;
            for(int i=0; i<n; i++){
                cnt[priorities[i]] +=1;
                q.add(new Document(i, priorities[i]));
                if(priorities[i] > max) max = priorities[i];
            }

            int pr = max;
            int order = 0;
            int answer = 0;

            while (!q.isEmpty()) {
                Document d = q.remove();

                while (cnt[pr] == 0) {
                    pr -= 1;
                }

                if (d.p == pr) {
                    cnt[pr] -= 1;
                    order += 1;
                    if (d.l == location) {
                        answer = order;
                    }
                } else {
                    q.add(d);
                }
            }

            System.out.println(answer);
        }


        
    }
}
