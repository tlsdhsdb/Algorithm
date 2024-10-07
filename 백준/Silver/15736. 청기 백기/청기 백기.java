import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 10/7/24
 **/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		int result = 0;
		for(int i=1;i<=N;i++){
			if(Math.pow(i,2) <= N){
				result ++;
			}else{
				break;
			}
		}

		System.out.println(result);
	}
}