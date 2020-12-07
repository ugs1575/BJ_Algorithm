package dataStructure.stack;

import java.io.*;
import java.util.*;

public class rightBiggestNumber_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[1000001];
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
            cnt[arr[i]] += 1;
        }

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while (!st.isEmpty() && cnt[arr[i]] >= cnt[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);

        }

        StringBuilder sb = new StringBuilder();
        for(int i:ans){
            sb.append(i+" ");
        }

        System.out.println(sb);
    }
}
