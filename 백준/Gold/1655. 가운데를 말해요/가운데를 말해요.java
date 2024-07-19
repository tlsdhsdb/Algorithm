import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 7/19/24
 **/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		// 중간값 이하의 숫자들을 저장
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// 중간값 이상의 숫자들을 저장
		int N = sc.nextInt();

		for(int i=0;i<N;i++){
			int num = sc.nextInt();

			if(maxHeap.size() == minHeap.size()){
				// 짝수일 경우
				minHeap.offer(num);
				maxHeap.offer(minHeap.poll());
			}else{
				//홀수인경우
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}