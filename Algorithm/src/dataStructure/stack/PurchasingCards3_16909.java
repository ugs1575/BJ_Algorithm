package dataStructure.stack;

import java.util.*;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class PurchasingCards3_16909 {
    static long calc(long n){
        return n*(n+1)/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] lg = new int[n+1];
        int[] rg = new int[n+1];
        int[] ls = new int[n+1];
        int[] rs = new int[n+1];
        Stack<Pair> sg = new Stack<Pair>();
        Stack<Pair> ss = new Stack<Pair>();

        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
            rs[i] = rg[i] = n;
            ls[i] = lg[i] = 1;
        }


        sg.push(new Pair(1, a[1]));
        ss.push(new Pair(1, a[1]));

        for(int i=2; i<=n; i++){
            while (!sg.isEmpty() && a[i] > sg.peek().second){
                rg[sg.peek().first] = i-1;
                //System.out.println(sg.peek().first);
                sg.pop();
            }
            sg.push(new Pair(i, a[i]));
            while (!ss.isEmpty() && a[i] < ss.peek().second){
                rs[ss.peek().first] = i-1;
                ss.pop();
            }
            ss.push(new Pair(i, a[i]));
        }
        sg.clear();
        ss.clear();
        sg.push(new Pair(n, a[n]));
        ss.push(new Pair(n, a[n]));
        for(int i=n-1; i>=0; i--){
            while (!sg.isEmpty() && a[i] > sg.peek().second){
                lg[sg.peek().first] = i+1;
                sg.pop();
            }
            sg.push(new Pair(i, a[i]));
            while (!ss.isEmpty() && a[i] < ss.peek().second){
                ls[ss.peek().first] = i+1;
                ss.pop();
            }
            ss.push(new Pair(i, a[i]));
        }


        long ans = 0;
        for(int i=1; i<=n; i++){
            int l = lg[i];
            int r = rg[i];
            System.out.println("less i : "+i+"  l: "+l+" r : "+r);
            long len = r-l+1;
            ans += (calc(len) - calc(r-i) - calc(i-l)) * a[i];
        }

        for(int i=1; i<=n; i++){
            int l = ls[i];
            int r = rs[i];
            long len = r-l+1;
            ans -= (calc(len) - calc(r-i) - calc(i-l)) * a[i];
        }

        System.out.println(ans);
    }
}
