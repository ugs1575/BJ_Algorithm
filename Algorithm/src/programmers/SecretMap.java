package programmers;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            temp[i] = arr1[i]|arr2[i];
        }

        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=n-1; j>=0; j--){
                char c = '#';
                if((temp[i] & (1<<j)) == 0){
                    c = ' ';
                }
                sb.append(c);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 1;
        int[] arr1 = {1};
        int[] arr2 = {1};
        SecretMap s = new SecretMap();
        s.solution(n, arr1, arr2);
    }
}
