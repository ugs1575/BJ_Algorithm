package dataStructure.stack;

import java.util.*;

public class Oasis_3015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        long ans = 0;
        Stack<Integer> s = new Stack<>();
        Stack<Integer> c = new Stack<>();
        for(int i=0; i<n; i++){
            int cnt = 1;
            while (!s.isEmpty() && s.peek() <= a[i]){
                ans += (long)c.peek();
                if(s.peek() == a[i]){
                    cnt += c.peek();
                }
                s.pop();
                c.pop();
            }

            if(!s.isEmpty() && s.peek() > a[i]){
                ans += 1L;
            }
            s.push(a[i]);
            c.push(cnt);
        }

        System.out.println(ans);

    }
}
