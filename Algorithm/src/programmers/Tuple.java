package programmers;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Tuple {
    public int[] solution(String s) {
        ArrayList<Integer>[] list = new ArrayList[1000001];
        for(int i=0; i<=1000000; i++){
            list[i] = new ArrayList<>();
        }
        //양끝 {} 제거
        s = s.substring(1, s.length()-1);

        int n = 0; //result 길이
        String[] str = s.split("}"); //집합끼리 나누기
        n = str.length;
        for(String tuple : str){
            if(tuple.charAt(0) == ',') tuple = tuple.substring(1);
            String[] element = tuple.split(","); //원소끼리 나누기
            for(int i=0; i<element.length; i++){
                String strNum = element[i];
                int num = 0;
                if(strNum.charAt(0) == '{'){
                    num = Integer.parseInt(strNum.substring(1));
                }else{
                    num = Integer.parseInt(strNum);
                }
                list[element.length].add(num);
            }
        }

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=1; i<=n; i++){
            for(int num : list[i]){
                set.add(num);
            }
        }

        int[] answer = new int[n];
        int idx = 0;
        for(int num : set){
            answer[idx ++] = num;
        }
        return answer;
    }
    public static void main(String[] args) {
        Tuple t = new Tuple();
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(t.solution(s));
    }
}
