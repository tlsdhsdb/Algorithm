import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 7/28/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		for(int a=0;a<=N;a++){
			for(int b=0;b<=N;b++){
				for(int c=0;c<=N;c++){
					if(a + b + c == N){
						// 남는 사탕이 없어야 합니다
						if(a >= b + 2){
							// 남규는 영훈이보다 2개이상 많은 사탕을 가져야 함
							if(a > 0 && b > 0 && c > 0){
								// 0개의 사탕을 받는 사람은 없어야 함
								if(c % 2 == 0){
									//택희가 받는 사탕의 수는 홀수개가 되어서는 안된다.
									answer++;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}