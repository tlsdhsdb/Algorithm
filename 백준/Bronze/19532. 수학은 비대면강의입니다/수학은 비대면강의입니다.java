import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
		int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if(num[0] * x + num[1] * y == num[2] && num[3] * x + num[4] * y == num[5]) {
					System.out.println(x + " " + y);
					return;
				}
			}
		}
	}
}