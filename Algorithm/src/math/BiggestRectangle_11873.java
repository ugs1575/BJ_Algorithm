/*
* Q6549_히스토그램에서 가장 큰 직사각형과 푸는 방식이 똑같은 문제이다
* 다른점은 매 행마다 높이를 구해서 직사각형 넓이를 구해줘야 하는 것이다.
*
* */


package Math;

import java.util.*;
import java.io.*;

public class BiggestRectangle_11873 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();
        while (n != 0 && m != 0){
            boolean ok = false;
            int[][] a = new int[n][m];
            for(int i=0; i<n; i++){
                s = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    a[i][j] = Integer.parseInt(s[j]);
                    if(a[i][j] == 1) ok = true;
                }
            }
            int ans = 0;
            if(ok){
                int[][] height = new int[n][m];
                for(int j=0; j<m; j++){
                    int sum = 0;
                    for(int i=0; i<n; i++){
                        if(a[i][j] == 0){
                            sum = 0;
                        }else{
                            sum += 1;
                        }
                        height[i][j] = sum;
                    }
                }

                for(int i=0; i<n; i++){
                    Stack<Integer> st = new Stack<Integer>();
                    for(int j=0; j<m; j++){
                        if (!st.isEmpty()) {
                            int top = st.peek();
                            while (!st.isEmpty() && height[i][j] < height[i][top]) {
                                top = st.pop();
                                int right = j - 1;
                                int left = 0;
                                if (!st.isEmpty()) {
                                    left = st.peek() + 1;
                                }
                                int size = height[i][top] * (right - left + 1);
                                if (size > ans) ans = size;
                                if (!st.isEmpty()) {
                                    top = st.peek();
                                }
                            }
                        }
                        st.add(j);
                    }

                    int right = m-1;
                    while (!st.isEmpty()){
                        int top = st.pop();
                        int left = 0;
                        if(!st.isEmpty()){
                            left = st.peek()+1;
                        }
                        int size = height[i][top] * (right-left+1);
                        if(size > ans) ans = size;
                    }
                }
            }

            sb.append(ans+"\n");

            s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);

        }

        System.out.print(sb);
    }
}
