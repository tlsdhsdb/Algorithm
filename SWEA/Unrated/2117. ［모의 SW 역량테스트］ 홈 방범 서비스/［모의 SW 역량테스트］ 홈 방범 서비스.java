import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
 * @since 2023-11-08
 **/
public class Solution {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int T,N,M;
	static int[][] map;
	static int[] profit = new int[22]; // 도시의 최대 크기만큼 배열을 생성
	static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
	static int maxHome,home;
	// 서비스를 제공받는 가장 많은 집의 개수
	// 총 집의 개수 -> 이걸 통해서 해당되지 않는 범위는 자를 것

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int i=1;i<22;i++) profit[i] = i * i + (i-1) * (i-1);
		// 이익을 저장한다

		for(int t=1;t<T+1;t++) {
			st = new StringTokenizer(br.readLine()," ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			maxHome = home = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) home++; // 집의 개수
				}
			}

			for (int k = 1; k < 22; k++) {
				// 범위
				if(home * M - profit[k] < 0 ) break;
				// 모든 집의 이익을 더해도 손해가 나는 상황이면 이 이상은 가지 않는다
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						bfs(i,j,k);
					}
				}
			}

			System.out.printf("#%d %d\n",t,maxHome);
		}
	}

	static void bfs(int x,int y,int k){
		// 시작지점
		// 범위
		Queue<Point> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		int depth = 0; // 범위만큼 depth 가 깊어진다
		int count = 0; // 집의 개수

		que.add(new Point(x,y));
		visited[x][y] = true;

		while(!que.isEmpty()){
			int size = que.size();

			if(depth == k) break; // 해당 depth까지 오면 중단한다

			for(int s = 0; s < size; s++){
				Point curr = que.poll();
				if(map[curr.x][curr.y] == 1) count++;

				for(Point d : dir){
					int nx = curr.x + d.x;
					int ny = curr.y + d.y;

					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(visited[nx][ny]) continue;

					visited[nx][ny] = true;
					que.add(new Point(nx,ny));
				}
			}
			depth++;
		}
		if(count *  M - profit[k] >= 0) maxHome = Math.max(count,maxHome);
	}
}