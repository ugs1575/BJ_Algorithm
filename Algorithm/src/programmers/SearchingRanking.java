package programmers;

import java.util.*;

public class SearchingRanking {
    static int[] solution(String[] info, String[] query) {
        /*
        지원자 분류
        0 : -, 1 : java, 2 : cpp, 3 : python
        0 : -, 1 : backend , 2 : frontend
        0 : -, 1 : junior , 2 : senior
        0 : -, 1 : chicken, 2 : pizza
        */
        HashMap<String, Integer> category = new HashMap<>();
        category.put("-", 0);
        category.put("java", 1);
        category.put("cpp", 2);
        category.put("python", 3);
        category.put("backend", 1);
        category.put("frontend", 2);
        category.put("junior", 1);
        category.put("senior", 2);
        category.put("chicken", 1);
        category.put("pizza", 2);

        //지원자별로 분류하기
        int[][][][][] categorized = new int[4][3][3][3][100001];
        for(String s : info){
            String[] temp = s.split(" ");
            int language = category.get(temp[0]);
            int position = category.get(temp[1]);
            int career = category.get(temp[2]);
            int food = category.get(temp[3]);
            int score = Integer.parseInt(temp[4]);
            categorized[language][position][career][food][score] += 1;

            int noCondition = 0;
            categorized[noCondition][position][career][food][score] += 1;
            categorized[language][noCondition][career][food][score] += 1;
            categorized[language][position][noCondition][food][score] += 1;
            categorized[language][position][career][noCondition][score] += 1;

            categorized[noCondition][noCondition][career][food][score] += 1;
            categorized[noCondition][position][noCondition][food][score] += 1;
            categorized[noCondition][position][career][noCondition][score] += 1;
            categorized[language][noCondition][noCondition][food][score] += 1;
            categorized[language][noCondition][career][noCondition][score] += 1;
            categorized[language][position][noCondition][noCondition][score] += 1;

            categorized[noCondition][noCondition][noCondition][food][score] += 1;
            categorized[noCondition][noCondition][career][noCondition][score] += 1;
            categorized[noCondition][position][noCondition][noCondition][score] += 1;
            categorized[language][noCondition][noCondition][noCondition][score] += 1;

            categorized[noCondition][noCondition][noCondition][noCondition][score] += 1;
        }

        //점수 마다 몇명이상인지 구해주기
        for(int i=0; i<4; i++){ //개발언어
            for(int j=0; j<3; j++){ //직군
                for(int k=0; k<3; k++){ //경력
                    for(int t=0; t<3; t++){ //소울푸드
                        int sum = 0;
                        for(int x=100000; x>=1; x--){ //점수
                            sum += categorized[i][j][k][t][x];
                            categorized[i][j][k][t][x] = sum;
                        }
                    }
                }
            }
        }

        int[] answer = new int[query.length];
        int idx = 0;
        for(String q : query){
            String[] temp = q.split(" ");
            int language = category.get(temp[0]);
            int position = category.get(temp[2]);
            int career = category.get(temp[4]);
            int food = category.get(temp[6]);
            int score = Integer.parseInt(temp[7]);
            int cnt = categorized[language][position][career][food][score];
            answer[idx++] = cnt;
        }

        return answer;

    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        solution(info, query);
    }
}
