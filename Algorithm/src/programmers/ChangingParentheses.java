package programmers;

import java.util.Stack;

public class ChangingParentheses {
    public String reverse(String u){
        StringBuilder sb = new StringBuilder();
        for(char c : u.toCharArray()){
            if(c == '('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }

        return sb.toString();
    }
    public boolean isCorrect(String u){
        int n = u.length();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c = u.charAt(i);
            if(c == '('){
                st.add(i);
            }else{
                if(st.isEmpty()){
                    return false;
                }else{
                    st.pop();
                }
            }
        }

        return true;
    }
    public String solution(String p) {
        int n = p.length();
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(n == 0) return "";
        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int open = 0;
        int close = 0;
        String u = "";
        String v = "";
        for(int i=0; i<n; i++){
            if(p.charAt(i) == '(') open += 1;
            else close += 1;
            if(open == close){
                u = p.substring(0,i+1);
                v = p.substring(i+1,n);
                break;
            }
        }
        //        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        //        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        //        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        //        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        //        4-3. ')'를 다시 붙입니다.
        //        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        //        4-5. 생성된 문자열을 반환합니다.
        StringBuilder sb = new StringBuilder();
        if(isCorrect(u)){
            String res = solution(v);
            sb.append(u);
            sb.append(res);
        } else{
            sb.append('(');
            String res = solution(v);
            sb.append(res);
            sb.append(')');
            u = u.substring(1, u.length()-1);
            sb.append(reverse(u));
        }

        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        ChangingParentheses obj = new ChangingParentheses();
        System.out.println(obj.solution("()))((()"));
    }
}
