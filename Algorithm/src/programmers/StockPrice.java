package programmers;

import java.util.Stack;

public class StockPrice {
    static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.add(i);
            }else{
                while (!st.isEmpty() && prices[st.peek()] > prices[i]){
                    int index = st.pop();
                    answer[index] = i - index;
                }

                st.add(i);

            }
        }

        while (!st.isEmpty()){
            int index = st.pop();
            answer[index] = (n-1) - index;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices = {3, 3, 3, 2, 2};
        solution(prices);
    }
}
