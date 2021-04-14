package programmers;

import java.util.TreeSet;

public class PickTwo {
    static TreeSet<Integer> set = new TreeSet<>();
    static void go(int start, int end, int index, int[] temp, int[] numbers){
        if(index == 2){
            int sum = 0;
            for(int i : temp){
                sum += numbers[i];
            }
            set.add(sum);
            return;
        }

        for(int i=start; i<=end; i++){
            temp[index] = i;
            go(i+1, end, index+1, temp, numbers);
        }
    }
    static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] temp = new int[2];
        go(0, n-1, 0, temp, numbers);
        int m = set.size();
        int[] answer = new int[m];
        int i = 0;
        for(int num : set){
            answer[i++] = num;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        System.out.println(solution(numbers));
    }
}
