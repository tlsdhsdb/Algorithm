import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 10/14/24
 **/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		while(N != 1){
			for(int i=2;i<=N;i++){
				if(N % i == 0) {
					System.out.println(i);
					N = N / i;
					break;
				}
			}
		}
	}
}