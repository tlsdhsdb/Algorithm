import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/11/15
 **/
public class Main {
	static class Point implements Comparable<Point> {
		int x,y;
		int value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}
	static int N,min;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int idx = 1;

		while(true){
			N = Integer.parseInt(br.readLine());

			if(N == 0) break;

			map = new int[N][N];
			min = Integer.MAX_VALUE;

			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//가장 최소값으로 가는 경우
			int answer = bfs();
			System.out.printf("Problem %d: %d\n",idx++,answer);


		}
	}
	static int bfs(){
		Queue<Point> pq = new PriorityQueue<>();
		int[][] dp = new int[N][N];
		for(int n=0;n<N;n++) Arrays.fill(dp[n],Integer.MAX_VALUE);

		pq.add(new Point(0,0,0));
		dp[0][0] = map[0][0];
		while(!pq.isEmpty()){
			Point curr = pq.poll();
			if(curr.x == N-1 && curr.y == N-1) min = Math.min(min,curr.value);
			for(int i=0;i<4;i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(dp[nx][ny] > dp[curr.x][curr.y] + map[nx][ny]){
					dp[nx][ny] = dp[curr.x][curr.y] + map[nx][ny];
					pq.add(new Point(nx,ny,dp[nx][ny]));
				}

			}
		}
		return dp[N-1][N-1];
	}
}