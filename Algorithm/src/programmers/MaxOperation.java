package programmers;

import java.util.*;

public class MaxOperation {
    public long operation(char op, long num1, long num2){
        if(op == '*'){
            return num1*num2;
        }else if(op == '+'){
            return num1+num2;
        }else{
            return num1-num2;
        }
    }
    public void cal(ArrayList<Long> numList, ArrayList<Character> operList, char op){
        for(int i=0; i< operList.size(); i++){
            if(operList.get(i) == op){
                long num1 = numList.get(i);
                long num2 = numList.get(i+1);
                long result = operation(op, num1, num2);
                numList.remove(i);
                numList.remove(i);
                numList.add(i, result);
                operList.remove(i);
                i--;
            }
        }
    }
    public long calc(ArrayList<Long> nums, ArrayList<Character> ops, char op1, char op2, char op3){
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> operList = new ArrayList<>();

        for(int i=0; i< nums.size(); i++){
            numList.add(nums.get(i));
        }

        for(int i=0; i< ops.size(); i++){
            operList.add(ops.get(i));
        }

        cal(numList, operList, op1);
        cal(numList, operList, op2);
        cal(numList, operList, op3);

        return numList.get(0);
    }
    public long solution(String expression) {
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        for(char c : expression.toCharArray()){
            if(c == '-' || c == '*' || c == '+'){
                ops.add(c);
            }
        }

        String[] tokens = expression.split("[-+*]");
        for(String num : tokens){
            nums.add(Long.parseLong(num));
        }


        long[] results = new long[6];
        results[0] = calc(nums, ops, '*','+','-');
        results[1] = calc(nums, ops, '*','-','+');
        results[2] = calc(nums, ops, '+','-','*');
        results[3] = calc(nums, ops, '+','*','-');
        results[4] = calc(nums, ops, '-','*','+');
        results[5] = calc(nums, ops, '-','+','*');

        long answer = 0;
        for(int i=0; i<6; i++){
            if(Math.abs(results[i]) > answer) {
                answer = Math.abs(results[i]);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String s = "100-200*300-500+20";
        MaxOperation m = new MaxOperation();
        System.out.println(m.solution(s));
    }
}
