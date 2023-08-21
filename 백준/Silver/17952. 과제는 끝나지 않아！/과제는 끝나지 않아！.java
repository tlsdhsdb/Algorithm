import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N; // 몇분인지 저장하는 정수 N
	static Stack<work> stack; // 업무를 저장할 스택 
	static int answer; // 정답을 저장할 변수
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 몇분이 주어지는지 나타내는 정수
		stack = new Stack<>(); // 이후에 들어오는 업무를 먼저 처리하는 후입선출 구조이기 때문에 스택 사용
		answer = 0; // 업무평가 점수를 저장할 변수
		
		for(int n = 1; n <= N ; n++) {
			// 주어지는 시간만큼 루프문 반복
			st = new StringTokenizer(br.readLine()," ");
			int idx = Integer.parseInt(st.nextToken());
			//업무의 인덱스를 받음
			
			if(idx != 0) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				stack.add(new work(idx,A,T));
				// 업무의 만점과,해결시간을 받게된다면
				// 스택에 해당정보를 저장합니다
				// work 라는 클래스를 생성하여 업무에 대한 정보를 저장할 수 있도록 함
			}
			
			if(!stack.isEmpty()) { //스택이 비어있지 않다면
				work top = stack.pop(); // 스택의 가장 위쪽의 업무를 pop 한다
				top.min -= 1; // 그리고 업무를 1분동안 했으니,업무 소요시간에서 1을 뺀다
				if(top.min == 0) answer += top.score; 
				// 만약 소요시간이 0이 된다면,업무를 처리했다는 의미이기 때문에 
				// 업무의 만점을 정답변수에 추가한다
				else stack.add(top);
				// 업무의 소요시간이 0이 되지 않았다면 다시 스택에 추가한다
			}
		}
		
		System.out.println(answer); // 정답을 출력한다
		
	}
	static class work{ // 업무의 정보를 저장하는 클래스
		//스택을 편하게 만들기 위해 업무 정보를 저장하는 클래스를 새로 작성함
		int idx; //업무의 인덱스
		int score; // 업무의 만점
		int min; // 업무 소요시간
		
		public work(int idx, int score, int min) {
			super();
			this.idx = idx;
			this.score = score;
			this.min = min;
		}
		// 업무정보를 저장하는 클래스의 생성자
	}
}