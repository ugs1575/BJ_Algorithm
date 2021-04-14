package programmers;

public class PresentationWithN {
    static int goal;
    static int n;
    static int[] arr = new int[9];
    static int go(int total, int cnt){
        int min = -1;
        if(cnt > 8) return -1;
        if(total == goal) return cnt;

        for(int i=1; i<=8; i++){
            int x = arr[i];

            int plus = go(total+x, cnt+i);
            if(plus != -1) {
                if (min == -1 || min > plus) min = plus;
            }

            int minus = go(total-x, cnt+i);
            if(minus != -1) {
                if (min == -1 || min > minus) min = minus;
            }

            int muliti = go(total*x, cnt+i);
            if(muliti != -1) {
                if (min == -1 || min > muliti) min = muliti;
            }

            int divide = go(total/x, cnt+i);
            if(divide != -1) {
                if (min == -1 || min > divide) min = divide;
            }
        }


        return min;

    }
    static int solution(int N, int number) {
        goal = number;
        n = N;

        //숫자 만들기
       for(int i=1; i<=8; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(N);
            }
            int x = Integer.parseInt(sb.toString());
            arr[i] = x;
        }

        int answer = go(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 11));
    }
}
