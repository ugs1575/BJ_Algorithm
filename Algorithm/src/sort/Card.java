/*나의 질문
 * 첫번째 소스에서는 arraylist를 사용했고 두번째 소스에서는 array로 첫번째 소스를 바꿔보았습니다.
 * 그런데 첫번째 소스는 틀리고, 두번째 소스는 맞았습니다.
 * 왜 arraylist를 쓰면 틀리다고 나오는 건가요?
 * 궁금합니다.*/

/*답변
 * 30번째 줄과 32번째 줄이 의도와 다르게 동작합니다.
 * list.get() 메소드의 반환값은 Long 이라고 하는 wrapped object 입니다.
 * object 에 대해서 == 연산자 또는 != 연산자를 사용하게 되면 object 내용물을 보는게 아니라 reference 가 동일한가 (즉, 같은 object 를 가리키는가) 를 판단합니다.
 * object 안에 들어있는 long 수치가 같은지 비교하려면 equals 메소드를 사용해야 합니다. */

//두번째 소스
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Card {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long list[] = new long[n];
		
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			list[i] = num;
		}
		
		Arrays.sort(list);
		
		
		int cnt = 1;
		int cnt_max = 0;
		long ans = list[0];
		
		for(int i=1; i<n; i++) {
			if(list[i-1] == list[i]) {
				cnt++;
			}else if(list[i-1] != list[i]) {
				cnt = 1;
			}
			
			if(cnt_max < cnt) {
				cnt_max = cnt;
				ans = list[i-1];
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}

