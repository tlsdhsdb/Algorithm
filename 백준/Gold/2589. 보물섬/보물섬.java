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
 * @since 1/28/24
 **/
public class Main {
	static class Point{
		int x,y;
		int time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int X,Y;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		map = new char[X][Y];

		int result = 0;

		for(int x=0;x<X;x++){
			map[x] = br.readLine().toCharArray();
		}

		for(int x=0;x<X;x++){
			for(int y=0;y<Y;y++){
				if(map[x][y] == 'L'){
					visited = new boolean[X][Y];
					int time = bfs(new Point(x,y,0));
					result = Math.max(result,time);
				}
			}
		}

		System.out.println(result);
	}
	static int bfs(Point start){
		Queue<Point> que = new ArrayDeque<>();
		int value = 0; // 가장 먼 곳까지 가는데 걸린 시간
		que.add(start);
		visited[start.x][start.y] = true;

		while(!que.isEmpty()){
			Point curr = que.poll();
			for(int i=0;i<4;i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if(nx < 0 || ny < 0 || nx >= X || ny >= Y) continue;
				if(map[nx][ny] == 'W') continue; // 바다로는 갈 수 없다
				if(visited[nx][ny]) continue; // 이미 방문한 곳으로는 갈 수 없다
				visited[nx][ny] = true;
				que.add(new Point(nx,ny,curr.time+1));
				value = Math.max(value,curr.time+1);
			}
		}
		return value;
	}
}