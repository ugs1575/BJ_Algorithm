package greedy;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    int p, d, w;
    Lecture(int p, int d, int w){
        this.p = p;
        this.d = d;
        this.w = w; //0이면 pair
    }

    @Override
    public int compareTo(Lecture o) {
        if(this.d > o.d){
            return -1;
        }else if(this.d == o.d){
            if(this.w < o.w) return -1;
            else if(this.w == o.w) return 0;
            else return 1;
        }else{
            return 1;
        }
    }
}

public class LectureTour_2109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        ArrayList<Lecture> alist = new ArrayList<>();
        for(int i=0; i<n; i++){
            int p = sc.nextInt();
            int d = sc.nextInt();
            if(d > max) max = d;
            alist.add(new Lecture(p, d, 0));
        }

        for(int i=max; i>=1; i--){
            alist.add(new Lecture(0,i,1));
        }

        Collections.sort(alist);

        /*for(Lecture l : alist){
            System.out.println(l.p+"/"+l.d+"/"+l.w);
        }*/

        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(Lecture l : alist){
            if(l.w == 0){
                q.offer(-l.p);
            }else{
                if(!q.isEmpty()){
                    int num = Math.abs(q.poll());
                    ans += num;
                }
            }
        }
        System.out.println(ans);
    }
}
