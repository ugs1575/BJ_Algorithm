package programmers;

import java.util.*;

public class NewMenu {
    static int n;
    static boolean[][] customer;
    static TreeMap<String, Integer> tm = new TreeMap<>();
    static int findCombi(int[] temp){
        int answer = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<temp.length; j++){
                if(customer[i][temp[j]]){ //해당 조합을 주문했는지 체크
                    cnt += 1;
                }
            }
            if(cnt == temp.length) answer += 1;
        }

        return answer;
    }
    static void makeCombi(int start, int end, int index, ArrayList<Integer> list, int[] temp, int[] max){
        if(index == temp.length){
            int res = findCombi(temp);

            StringBuilder sb = new StringBuilder();
            for(int i=0; i < temp.length; i++){
                char c = (char) (temp[i]+'A');
                sb.append(c);
            }
            tm.put(sb.toString(), res);

            if(res > max[temp.length]) max[temp.length] = res;
            return;
        }
        for(int i=start; i<=end; i++){
            temp[index] = list.get(i);
            makeCombi(i+1, end, index+1, list, temp, max);
        }
    }
    static String[] solution (String[] orders, int[] course) {
        n = orders.length;

        //단품 메뉴 주문 횟수 저장, 2번 이상 주문한건 따로 저장
        customer = new boolean[20][26];
        int[] orderCnt = new int[26];
        for(int i=0; i<orders.length; i++){
            for(int j=0; j<orders[i].length(); j++){
                int c = orders[i].charAt(j)-'A';
                customer[i][c] = true;
                orderCnt[c] += 1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(orderCnt[i] >= 2) list.add(i);
        }


        //두번 이상 주문된 것들로 코스 요리 조합 만들기
        int[] max = new int[11]; //코스요리 길이마다 최댓값 저
        for(int limit: course){
            int[] temp = new int[limit];
            makeCombi(0, list.size()-1, 0, list, temp, max);
        }

        ArrayList<String> answerTemp = new ArrayList<>();
        tm.forEach((key, value) -> {
            if (value >= 2 && max[key.length()] == value) answerTemp.add(key);
        });

        String[] answer = new String[answerTemp.size()];
        for(int i=0; i<answerTemp.size(); i++){
            answer[i] = answerTemp.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        solution(orders, course);
    }
}
