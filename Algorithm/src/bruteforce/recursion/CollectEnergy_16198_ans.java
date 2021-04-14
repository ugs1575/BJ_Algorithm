package bruteforce.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectEnergy_16198_ans {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<n; i++){
            a.add(sc.nextInt());
        }
        System.out.println(go(a));
    }

    static int go(ArrayList<Integer> a){
        int n = a.size();
        if(n == 2) return 0;
        int ans = 0;
        for(int i=1; i<n-1; i++){
            int energy = a.get(i-1) * a.get(i+1);
            ArrayList<Integer> b = new ArrayList<>(a);
            b.remove(i);
            for(int j=0; j<b.size(); j++){
                System.out.print(b.get(j)+" ");
            }
            System.out.println();
            energy += go(b);
            if(ans < energy){
                ans = energy;
            }
        }

        return ans;
    }

}
