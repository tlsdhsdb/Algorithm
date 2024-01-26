import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/26/24
 **/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 돌의 개수

		//돌이 N개일 경우 상근이가 지는지 적기
		//상근이가 지는 경우
		//마지막 돌을 가져가는 사람이 이긴다
		//0 : 돌을 못가져가서 진다
		//1 : 돌을 한개 가져갈 수 있어서 이김
		//2 : 마지막 돌을 창영이가 가져감
		//3 : 돌 3개를 모두 상근이가 가져가면 이김
		//4 : 돌 3개 / 돌1개

		//홀수일때 이기고, 짝수일때 진다

		System.out.println(N%2==0?"CY":"SK");

	}
}