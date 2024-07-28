import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 한곳에서 모일 때, 비용을 최소화 하기 위해서는 집 중 하나의 위치에 모이면 됨
 * 집이 두개일 경우에도 똑같음 !
 * @see
 * @since 7/28/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] x_arr = new int[N];
		int[] y_arr = new int[N];
		int[][] arr = new int[N][2];

		int[] answer = new int[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			x_arr[n] = x;
			y_arr[n] = y;
			arr[n] = new int[]{x,y};
			answer[n] = -1; // 거리 초기화
		}

		for(int x : x_arr) {
			for(int y : y_arr) {
				List<Integer> distance = new ArrayList<>();

				for(int[] xy : arr){
					int d = Math.abs(x - xy[0]) + Math.abs(y - xy[1]);
					distance.add(d);
				}
				//하나의 좌표에 대해서 다른 좌표들과의 거리 측정

				Collections.sort(distance);
				int tmp = 0;

				for(int i=0;i<distance.size();i++){
					int d = distance.get(i);
					tmp += d;
					if(answer[i] == -1){
						answer[i] = tmp;
					}else{
						answer[i] = Math.min(answer[i],tmp);
					}
				}
			}
		}
		for(int a : answer){
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}