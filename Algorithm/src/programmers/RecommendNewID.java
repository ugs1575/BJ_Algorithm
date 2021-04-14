package programmers;

public class RecommendNewID {
    static String solution(String new_id) {
        new_id = new_id.toLowerCase(); //1단계

        //2단계
        new_id = new_id.replaceAll("[^a-z0-9._-]","");

        int n = new_id.length();
        //3단계
        if(n >= 1) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            n = new_id.length();
            for (int i = 0; i < n - 1; i++) {
                if (new_id.charAt(i) == '.') {
                    if (new_id.charAt(i + 1) == '.') {
                        cnt += 1;
                    } else {
                        sb.append('.');
                        cnt = 0;
                    }
                } else {
                    sb.append(new_id.charAt(i));
                }
            }

            if (cnt > 0) sb.append('.');
            else sb.append(new_id.charAt(n - 1));

            new_id = sb.toString();
        }

        //4단계
        n = new_id.length();
        if(n >= 1 && new_id.charAt(0) == '.') new_id = new_id.substring(1, n);
        n = new_id.length();
        if(n >= 1 && new_id.charAt(n-1) == '.') new_id = new_id.substring(0, n-1);

        //5단계
        if(new_id.equals("")) new_id = "a";

        //6단계
        n = new_id.length();
        if(n >= 16) new_id = new_id.substring(0, 15);

        while (new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        //7단계
        n = new_id.length();
        char last = new_id.charAt(n-1);
        StringBuilder sb = new StringBuilder();
        sb.append(new_id);
        while (new_id.length() <= 2){
            sb.append(last);
            new_id = sb.toString();
        }


        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
