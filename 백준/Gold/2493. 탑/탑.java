import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/26/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();

		st = new StringTokenizer(br.readLine()," ");
		for(int n=1;n<=N;n++){
			int top = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()){
				if(stack.peek()[1] >= top){ //이전 값이 더 크냐?
					System.out.print(stack.peek()[0] + " "); // 수신했다
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()){
				System.out.print("0 ");
			}
			stack.push(new int[]{n,top});
		}
	}
}