package programmers;

public class Snail {
    static int[] solution(int n) {
        int temp = n;
        int[][] a = new int[n][n];
        int row = 0;
        int col = 0;
        int num = 1;
        int turn = n + 1;
        while (turn >= 1) {
            //아래
            turn -= 1;
            n = turn;
            if (turn == 0) break;
            for (int i = row; i < row + turn; i++) {
                a[i][col] = num++;
            }

            //오른쪽
            turn -= 1;
            if (turn == 0) break;
            for (int j = col + 1; j < col + 1 + turn; j++) {
                a[row + n - 1][j] = num++;
            }

            //대각선
            turn -= 1;
            if (turn == 0) break;
            int r = row + n - 2;
            int c = col + n - 2;
            while (r != row && c != col) {
                a[r--][c--] = num++;
            }

            col += 1;
            row += 2;

        }

        row = 0;
        col = 0;
        int index = 0;
        int[] answer = new int[num-1];
        while (row < temp){
            for (int j = 0; j <= col; j++) {
                answer[index++] = a[row][j];
            }
            row += 1;
            col += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(5);
    }
}
