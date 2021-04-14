package programmers;

public class TakingPhoto {
    static int answer = 0;
    public boolean isCorrect(String[] data, char[] temp) {
        StringBuilder sb = new StringBuilder();
        for(char c:temp){
            sb.append(c);
        }
        String line = sb.toString();

        for(String s : data){
            int start = s.indexOf(s.charAt(0));
            int end = s.indexOf(s.charAt(2));

            if(s.charAt(3)=='=' && Math.abs(start-end)-1!=s.charAt(4)-'0'){
                return false;
            }else if(s.charAt(3)=='<' && Math.abs(start-end)-1>=s.charAt(4)-'0'){
                return false;
            }else if(s.charAt(3)=='>' && Math.abs(start-end)-1<=s.charAt(4)-'0'){
                return false;
            }
        }

        return true;
    }
    public void permutation(String[] data, char[] temp, boolean[] check, char[] friend_list, int index) {
        if(index == temp.length){
            if(isCorrect(data, temp)) {
                answer += 1;
            }
            return;
        }

        for(int i=0; i<temp.length; i++){
            if(check[i]) continue;
            temp[index] = friend_list[i];
            check[i] = true;
            permutation(data, temp, check, friend_list, index+1);
            check[i] = false;
        }
    }
    public int solution(int n, String[] data) {
        char[] temp = new char[8];
        boolean[] check = new boolean[8];
        char[] friend_list = {'A','C','F','J','M','N','R','T'};
        permutation(data, temp, check, friend_list, 0);

        return answer;
    }



    public static void main(String[] args) {
        TakingPhoto t = new TakingPhoto();
        int n = 0;
        String[] data = {"N~F=0", "F~T=5","T~F=1"};
        System.out.println(t.solution(n, data));
    }
}
