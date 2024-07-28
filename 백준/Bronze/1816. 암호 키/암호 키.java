import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 100만보다 작고 2이상의 약수를 가지고 있다면,틀린 비밀번호
 * 만일 S의 모든 소인수가 10^6보다 크다면 그 수는 적절한 암호 키이고, 그렇지 않은 경우는 적절하지 못한 암호 키가 된다.
 * @see
 * @since 7/28/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for(int n=0;n<N;n++){

			long S = Long.parseLong(br.readLine());
			boolean isPassword = true;
			for(int i=2;i<=1000000;i++){
				if(S%i==0){
					isPassword = false;
					break;
				}
			}

			if(isPassword) {
				sb.append("YES");
			}else {
				sb.append("NO");
			}

			sb.append("\n");

		}
		System.out.println(sb);
	}
}