package Sort;

import java.io.*;
import java.util.Arrays;

/**
 * Created by woogyeongseo on 30/11/19.
 *
 * 자바 comparable / comparator 정리 -> [출처] https://cwondev.tistory.com/15
 *
 * 여기서 동일하게 SoccerPlayer 객체를 생성하고, 배열이나 ArrayList 형태로 만들었을 경우
 * Arrays.sort(), Collections.sort() 는 작동할까?
 *
 * 답부터 말하자면 오류가 발생한다.
 * 이유는 정렬을 시도했지만, 객체내의 어떤 변수를 기준으로 정렬할지 정하지 않았기 때문.
 *
 * String타입의 배열이나 ArrayList는 값이 하나지만, 객체를 정렬할 경우 객체 내의 어떤 변수로 정렬할지 만들어줘야 한다.



 출처: https://cwondev.tistory.com/15 [잡동사니 정보공유]
 */
public class BubbleSort {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Num arr[] = new Num[n];
        for(int i=0; i<n; i++){
            arr[i] = new Num();
            arr[i].value = Integer.parseInt(br.readLine());
            arr[i].index = i;

        }

        Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<n; i++){
            if(max < arr[i].index-i){
                max = arr[i].index - i;
            }
        }

        bw.write(max+1+"");
        bw.flush();
        bw.close();

    }


}
class Num implements Comparable<Num>{
    int value;
    int index;

    @Override
    public int compareTo(Num o){
        return this.value - o.value;
    }

}
