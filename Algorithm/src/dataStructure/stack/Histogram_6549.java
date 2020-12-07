package dataStructure.stack;

import java.io.*;
import java.util.*;

public class Histogram_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            if(s.equals("0")) break;

            String[] a = s.split(" ");
            int n = Integer.parseInt(a[0]);
            long[] height = new long[n];
            long[] size = new long[n];
            //높이 저장
            for(int i=0; i<n; i++) {
                height[i] = Long.parseLong(a[i+1]);
            }

            Stack<Integer> st = new Stack<>();
            for(int i=0; i<n; i++){
                //top 보다 다음 것이 더 작다면 더이상 top의 높이로 직사각형을 만들 수 없다.
                while (!st.isEmpty() && height[i] < height[st.peek()]){
                    long right = i - 1;
                    long left = 0;
                    int h = st.pop();
                    if (!st.isEmpty()) {
                        left = st.peek() + 1;
                    }

                    long r = (right - left + 1) * height[h];
                    size[h] = r;
                }

                st.push(i);

            }

            while (!st.isEmpty()){
                long right = n-1;
                long left = 0;
                int h = st.pop();
                if(!st.isEmpty()){
                    left = st.peek()+1;
                }
                long r = (right-left+1)*height[h];
                size[h] = r;
            }

            Arrays.sort(size);
            System.out.println(size[n-1]);
        }

    }
}
