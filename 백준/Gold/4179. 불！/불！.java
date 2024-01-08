import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 지훈이와 불이 모두 움직이는 문제
 * 불의 경우 다른 변수 없이 움직이는 방향이 일정하기 때문에 매분마다 어떻게 움직이는지 체크한 배열 필요
 * 지훈이의 경우 bfs로 모든 경우의 수를 탐색하면서 해당 자리가 해당 시간에 불이 있는지 체크하며 탐색한다
 * @see
 * https://www.acmicpc.net/problem/4179
 * @since 1/8/24
 **/
public class Main {
	static class Point{
		int r,c;
		int t;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static int R,C;
	static char[][] map;
	static int[][] fire; // 불이는 번지는 시간을 나타낸 지도
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		fire = new int[R][C];

		Queue<Point> fireQue = new ArrayDeque<>();
		Queue<Point> que = new ArrayDeque<>();

		for(int r=0;r<R;r++){
			map[r] = br.readLine().toCharArray();
			for(int c=0;c<C;c++){
				if(map[r][c] == 'F') {
					fireQue.add(new Point(r,c));
					fire[r][c] = 1;
				}else if(map[r][c] == 'J'){
					map[r][c] = '.';
					que.add(new Point(r,c,1));
				}
			}
		}

		//시간당 불의 경로를 나타내는 탐색
		while(!fireQue.isEmpty()){
			Point curr = fireQue.poll();
			int time = fire[curr.r][curr.c];

			for(int i=0;i<4;i++){
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(fire[nr][nc] != 0) continue;
				if(map[nr][nc] == '#') continue;
				fire[nr][nc] = time + 1;
				fireQue.add(new Point(nr,nc));
			}
		}

		boolean[][] visited = new boolean[R][C];

		while(!que.isEmpty()){
			Point curr = que.poll();
			visited[curr.r][curr.c] = true;

			for(int i=0;i<4;i++){
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					System.out.println(curr.t);
					return;
				}

				if(map[nr][nc] == '#') continue;
				if(visited[nr][nc]) continue;
				if(fire[nr][nc] != 0 && (curr.t+1) >= fire[nr][nc]) continue;

				visited[nr][nc] = true;
				que.add(new Point(nr,nc,curr.t+1));
			}
		}

		System.out.println("IMPOSSIBLE");
	}
}