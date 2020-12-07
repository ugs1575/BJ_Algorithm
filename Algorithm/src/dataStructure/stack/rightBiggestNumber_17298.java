package dataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class rightBiggestNumber_17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek() <= a[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(a[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i:ans){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }
}
