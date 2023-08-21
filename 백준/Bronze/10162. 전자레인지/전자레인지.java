import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 최소버튼 조작 
 * */
public class Main {
	static int T; // 요리시간
	static int[] answer = new int[3]; // 버튼 별 정답을 나타내는 배열 순서는 A,B,C 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		// 요리시간 입력
		
		// 1. 1의 자리수가 남는 경우, 버튼으로만 시간을 표현할 수 없다
		// 2. 무조건 5분짜리 버튼을 먼저 돌려보아야 한다.
		
		char []timeCheck = String.valueOf(T).toCharArray(); // case 1 . 1의 자리수가 남는 경우
		// 해당 경우를 체크하기 위하여 요리시간을 char 배열로 바꾼다
		
		if(timeCheck[timeCheck.length-1] - '0' > 0) {
			//해당 배열의 마지막 숫자가, 즉 1의 자리 수가 0보다 클 경우
			//불가능한 경우이기 때문에 -1을 추가한다
			sb.append(-1);
		}else {
			//1의 자리수가 없는 수의 경우 최소 버튼을 구하기 위한 계산을 시작한다
			while(true) {
				if(T < 10 ) {
					//시간이 10보다 작아지면 반복문을 멈춘다
					//즉,버튼으로 표현할 수 있는 수보다 작다면 반복문을 멈춘다
					break;
				}
				
				if(T >= 300) {
					// 시간이 300과 같거나 클때를 기준으로 처음은 무조건 가장 큰 수를 확인한다
					answer[0] += T / 300; // 나누어진다면 얼마에 나누어 떨어지는지 결과값에 추가해준다
					T = T % 300; // 나머지 값으로 시간을 초기화 해준다
				}else {
					//만약 시간이 300보다 작을경우
					//60일 경우와 10일 경우로 나누어 체크한다
					if(T >= 60) { // 남은 시간이 60과 같거나 클 경우
						answer[1] += T / 60; // 정답에 60으로 나눈 수를 정답배열에 추가해준다
						T = T % 60; // 나머지 값으로 시간을 초기화 해준다
					}else { // 남은 시간이 10과 같거나 클 경우
						answer[2] += T / 10;  // 정답에 10으로 나눈 수를 정답배열에 추가해준다
						T = T % 10; // 나머지 값으로 시간을 초기화 해준다
					}
				}
			}
			
			if(T == 0 ) {
				//남은 시간이 0이라면,버튼으로만 표현가능한 시간이기 때문에 정답배열을 출력한다
				for(int ans : answer) {
					sb.append(ans + " ");
				}
			}else {
				//남은 시간이 0보다 크거나 10보다 작은 경우(참고로 while문이 멈추는 조건이 10보다 작을때였다)
				//버튼으로만 표현 불가능한 시간이기 때문에 -1을 출력한다
				sb.append(-1);
			}
		}
	
		System.out.println(sb);
		

	}

}