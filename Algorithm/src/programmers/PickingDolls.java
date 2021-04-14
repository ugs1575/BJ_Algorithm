package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class PickingDolls {
    static int solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = board[0].length;
        ArrayList<Integer>[] alist = new ArrayList[m+1];
        for(int i=0; i<=m; i++){
            alist[i] = new ArrayList<Integer>();
        }

        for(int j=0; j<m; j++){
            for(int i=n-1; i>=0; i--){
                if(board[i][j] != 0){
                    alist[j+1].add(board[i][j]);
                }
            }
        }

        Stack<Integer> st1 = new Stack<>();
        for(int i=0; i<moves.length; i++){
            int crane_num = moves[i];
            int crane_size = alist[crane_num].size();
            if(crane_size > 0){
                int doll = alist[crane_num].remove(crane_size-1);
                st1.add(doll);
            }
        }

        int answer = 0;
        Stack<Integer> st2 = new Stack<>();
        while (!st1.isEmpty()){
            int doll = st1.pop();
            if(!st2.isEmpty()){
                int top = st2.peek();
                if(doll == top){
                    answer += 2;
                    st2.pop();
                }else{
                    st2.add(doll);
                }
            }else{
                st2.push(doll);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
