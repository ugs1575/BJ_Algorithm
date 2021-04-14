package programmers;

import java.util.ArrayList;

public class DartGame {
    public int solution(String dartResult) {
        int n = dartResult.length();
        ArrayList<Integer> bonusIndex = new ArrayList<>();
        for(int i=0; i<n; i++){
            int c = dartResult.charAt(i);
            //보너스 인덱스를 담는다.
            if(c == 83 || c == 68 || c == 84){
                bonusIndex.add(i);
            }
        }

        int startIndex = 0;
        int lastIndex = 0;
        int i = 0;
        int[] totalScore = new int[3];
        for(int b_index:bonusIndex){
            //옵션이 존재하지 않는다면 보너스 인덱스가 마지막 인덱스
            lastIndex = b_index;
            //점수
            int score = Integer.parseInt(dartResult.substring(startIndex, lastIndex));
            //보너스 계산
            char bonus = dartResult.charAt(b_index);
            if(bonus == 'D'){
                score = (int) Math.pow(score, 2);
            }else if(bonus == 'T'){
                score = (int) Math.pow(score, 3);
            }
            //만약 옵션이 존재한다면 한 게임의 마지막 인덱스는 옵션 인덱스
            if(b_index+1 < n){
                char option = dartResult.charAt(b_index+1);
                if(option == '*'){
                    //처음이 아니면 이전 인덱스 스코어 가져와서 두배
                    if(i != 0) totalScore[i-1] *= 2;
                    score *= 2;
                    lastIndex = b_index+1;
                }else if(option == '#'){
                    score *= -1;
                    lastIndex = b_index+1;
                }
            }
            System.out.println("startIndex : "+startIndex);
            System.out.println("lastIndex : "+lastIndex);
            totalScore[i] = score;
            i += 1;
            startIndex = lastIndex+1;
        }

        int answer = 0;
        for(int s:totalScore){
            answer += s;
        }
        return answer;
    }
    public static void main(String[] args) {
        DartGame d = new DartGame();
        System.out.println(d.solution("1D2S3T*"));
    }
}
