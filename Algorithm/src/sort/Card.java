/*���� ����
 * ù��° �ҽ������� arraylist�� ����߰� �ι�° �ҽ������� array�� ù��° �ҽ��� �ٲ㺸�ҽ��ϴ�.
 * �׷��� ù��° �ҽ��� Ʋ����, �ι�° �ҽ��� �¾ҽ��ϴ�.
 * �� arraylist�� ���� Ʋ���ٰ� ������ �ǰ���?
 * �ñ��մϴ�.*/

/*�亯
 * 30��° �ٰ� 32��° ���� �ǵ��� �ٸ��� �����մϴ�.
 * list.get() �޼ҵ��� ��ȯ���� Long �̶�� �ϴ� wrapped object �Դϴ�.
 * object �� ���ؼ� == ������ �Ǵ� != �����ڸ� ����ϰ� �Ǹ� object ���빰�� ���°� �ƴ϶� reference �� �����Ѱ� (��, ���� object �� ����Ű�°�) �� �Ǵ��մϴ�.
 * object �ȿ� ����ִ� long ��ġ�� ������ ���Ϸ��� equals �޼ҵ带 ����ؾ� �մϴ�. */

//�ι�° �ҽ�
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

