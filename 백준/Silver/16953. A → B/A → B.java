import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/20/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int cnt = 1;
		// 반대로 접근하기
		// B -> A 를 만들자
		while(A != B){
			if(B < A){
				System.out.println(-1);
				System.exit(0);
			}
			if(B % 10 == 1) B /= 10;
			// 마지막 자리수가 1이라면 1의자리를 없앤다
			else if(B % 2 == 0) B /= 2;
			else {
				System.out.println(-1);
				System.exit(0);
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}