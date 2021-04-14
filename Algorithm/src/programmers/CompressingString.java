package programmers;

public class CompressingString {
    static int solution(String s) {
        int n = s.length();
        int answer = n;
        for(int i=1; i<=n/2; i++){ //나누는 단위
            StringBuilder sb = new StringBuilder();
            String str1 = s.substring(0, i);
            int cnt = 1;
            int j;
            for(j=i; j<=n; j=j+i){
                int last = j+i;
                if(j+i > n) last = n;
                String str2 = s.substring(j, last);
                if(str1.equals(str2)){
                    cnt += 1;
                } else{
                    if(cnt == 1) sb.append(str1);
                    else{
                        sb.append(cnt);
                        sb.append(str1);
                    }
                    str1 = s.substring(j, last);
                    cnt = 1;
                }

            }

            if(j > n){
                if(cnt == 1) sb.append(str1);
                else{
                    sb.append(cnt);
                    sb.append(str1);
                }
            }
            System.out.println(sb);

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;

    }

    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        System.out.println(solution(s));
    }
}
