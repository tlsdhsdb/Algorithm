import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
 * @since 1/21/24
 **/
public class Main {
	static class Point implements Comparable<Point>{
		int x,y;
		int block;

		public Point(int x, int y, int block) {
			this.x = x;
			this.y = y;
			this.block = block;
		}

		@Override
		public int compareTo(Point o) {
			return this.block - o.block;
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N,M;
	static char[][] map;
	static int [][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		dp = new int[M][N];

		for(int m=0;m<M;m++){
			map[m] = br.readLine().toCharArray();
			Arrays.fill(dp[m],Integer.MAX_VALUE);
		}
		bfs();
		System.out.println(dp[M-1][N-1]);

	}
	static void bfs(){
		Queue<Point> que = new PriorityQueue<Point>();
		dp[0][0] = 0;

		que.add(new Point(0,0,0));

		while(!que.isEmpty()){
			Point curr = que.poll();

			for(int i=0;i<4;i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int block = curr.block;

				if(nx < 0 || nx >= M|| ny < 0 || ny >= N) continue;

				if(map[nx][ny] == '1') block++;

				if(dp[nx][ny] > block){
					dp[nx][ny] = block;
					que.add(new Point(nx,ny,block));
				}
			}
		}
	}
}