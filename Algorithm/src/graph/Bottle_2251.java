package graph;

import java.util.*;

class Pair6{
    int a, b, c;
    Pair6(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Bottle_2251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ca = sc.nextInt();
        int cb = sc.nextInt();
        int cc = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        boolean[][][] check = new boolean[201][201][201];
        Queue<Pair6> q = new LinkedList<>();
        list.add(cc);
        check[0][0][cc] = true;
        q.add(new Pair6(0,0,cc));
        while (!q.isEmpty()){
            Pair6 p = q.remove();

            int a = p.a;
            int b = p.b;
            int c = p.c;

            if(p.c > 0){
                //c->a
                if(ca > p.a){
                    if(p.a+p.c <= ca){
                        a = p.a+p.c;
                        c = 0;
                    }else{
                        a = ca;
                        c = p.a+p.c-ca;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("1 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }
                }

                //c->b
                if(cb > p.b){
                    a = p.a;
                    b = p.b;
                    c = p.c;
                    if(p.b+p.c <= cb){
                        b = p.b+p.c;
                        c = 0;
                    }else{
                        b = cb;
                        c = p.b+p.c-cb;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("2 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }
                }
            }

            if(p.b > 0){
                //b->a
                if(ca > p.a){
                    a = p.a;
                    b = p.b;
                    c = p.c;
                    if(p.b+p.a <= ca){
                        a = p.b+p.a;
                        b = 0;
                    }else{
                        a = ca;
                        b = p.b+p.a-ca;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("3 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }
                }

                //b->c
                if(cc > p.c){
                    a = p.a;
                    b = p.b;
                    c = p.c;
                    if(p.b+p.c <= cc){
                        c = p.b+p.c;
                        b = 0;
                    }else{
                        c = cc;
                        b = p.b+p.c-cc;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("4 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }
                }
            }

            //a->b
            if(p.a > 0){
                if(cb > p.b){
                    a = p.a;
                    b = p.b;
                    c = p.c;
                    if(p.b+p.a <= cb){
                        b = p.b+p.a;
                        a = 0;
                    }else{
                        b = cb;
                        a = p.b+p.a-cb;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("5 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }
                }

                //a->c
                if(cc > p.c){
                    a = p.a;
                    b = p.b;
                    c = p.c;
                    if(p.c+p.a <= cc){
                        c = p.c+p.a;
                        a = 0;
                    }else{
                        c = cc;
                        a = p.c+p.a-cc;
                    }
                    if(!check[a][b][c]){
                        if(a == 0) list.add(c);
                        check[a][b][c] = true;
                        System.out.println("6 / "+a+"/"+b+"/"+c);
                        q.add(new Pair6(a,b,c));
                    }

                }
            }


        }


        Collections.sort(list);
        for(int i:list){
            System.out.println(i);
        }

    }

}
