package programmers;

public class PressingKeypad {
    public String solution(int[] numbers, String hand) {
        int[] keypad = {2,0,2,1,0,2,1,0,2,1};
        int[][] dist = new int[10][12];
        //2까지 거리 1
        dist[2][1] = dist[2][5] = dist[2][3] = 1;
        //2까지 거리 2
        dist[2][4] = dist[2][6] = dist[2][8] = 2;
        //2까지 거리 3
        dist[2][7] = dist[2][0] = dist[2][9] = 3;
        //2까지 거리 4
        dist[2][10] = dist[2][11] = 4;

        //5까지 거리 1
        dist[5][2] = dist[5][4] = dist[5][6] = dist[5][8] = 1;
        //5까지 거리 2
        dist[5][1] = dist[5][3] = dist[5][7] = dist[5][9] = dist[5][0] = 2;
        //5까지 거리 3
        dist[5][10] = dist[5][11] = 3;

        //8까지 거리 1
        dist[8][5] = dist[8][7] = dist[8][9] = dist[8][0] = 1;
        //8까지 거리 2
        dist[8][4] = dist[8][6] = dist[8][2] = dist[8][10] = dist[8][11] = 2;
        //8까지 거리 3
        dist[8][1] = dist[8][3] = 3;

        //0까지 거리 1
        dist[0][8] = dist[0][10] = dist[0][11] = 1;
        //0까지 거리 2
        dist[0][7] = dist[0][5] = dist[0][9] = 2;
        //0까지 거리 3
        dist[0][4] = dist[0][2] = dist[0][6] = 3;
        //0까지 거리 4
        dist[0][1] = dist[0][3] = 4;


        StringBuilder sb = new StringBuilder();
        int curleft  = 10;
        int curright = 11;
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            if(i == 0 && keypad[num] == 2){
                if(hand.equals("left")){
                    curleft = num;
                    sb.append('L');
                }else{
                    curright = num;
                    sb.append('R');
                }
            }else{
                if(keypad[num] == 0){
                    sb.append('L');
                    curleft = num;
                }else if(keypad[num] == 1){
                    sb.append('R');
                    curright = num;
                }else{
                    int distleft = dist[num][curleft];
                    int distright = dist[num][curright];
                    if(distleft < distright){
                        sb.append('L');
                        curleft = num;
                    }else if(distleft == distright){
                        if(hand.equals("left")){
                            curleft = num;
                            sb.append('L');
                        }else{
                            curright = num;
                            sb.append('R');
                        }
                    }else{
                        sb.append('R');
                        curright = num;
                    }
                }
            }
        }


        String answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        PressingKeypad p = new PressingKeypad();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(p.solution(numbers, hand));
    }
}
