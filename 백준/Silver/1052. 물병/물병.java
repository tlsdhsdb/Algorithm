import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2/3/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = 0;

		while(Integer.bitCount(N++) > K){
			//비트에서 1의 개수가 K보다 커질때까지 계속하기
			//안된다면 1을 더하기 = 물통사기
			answer ++;
		}

		System.out.println(answer);
	}
}