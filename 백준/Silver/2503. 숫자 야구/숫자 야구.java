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
		int[][] hints = new int[N][3];
		int answer = 0;

		for(int n=0;n<N;n++){
			String[] input = br.readLine().split(" ");

			int num = Integer.parseInt(input[0]);
			int strike = Integer.parseInt(input[1]);
			int ball = Integer.parseInt(input[2]);

			hints[n] = new int[] {num, strike, ball};
		}

		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				for(int k=1;k<10;k++){
					int count = 0;

					if(i==j || j==k || k==i) continue;
					//서로 다른 숫자를 가지지 않은 경우에는 pass
					
					for(int[] hint : hints){
						int num = hint[0];
						int strike = hint[1];
						int ball = hint[2];

						int s = 0;
						int b = 0;

						int num1 = num/100;
						int num2 = (num/10)%10;
						int num3 = num%10;

						if(num1 == i) s++;
						if(num2 == j) s++;
						if(num3 == k) s++;

						if(num1 == j || num1 == k) b++;
						if(num2 == i || num2 == k) b++;
						if(num3 == i || num3 == j) b++;

						if(s == strike && b == ball){
							count++;
						}
					}

					if(count == N){
						answer++;
					}
				}
			}

		}

		System.out.println(answer);
	}
}