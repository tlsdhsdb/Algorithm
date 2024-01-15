import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,L,R;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<Point> que;
	static int[][] map;
	static boolean[][] visited;
	static boolean isOpen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		isOpen = false; // 국경 열리는 여부를 저장하는 변수
		int answer = 0; // 인구이동이 발생하는 일수

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true){
			isOpen = false;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!visited[i][j]) bfs(new Point(i,j));
				}
			}
			if(!isOpen) break;
			answer++;
		}

		System.out.println(answer);
	}
	static void bfs(Point start){
		Queue<Point> que = new ArrayDeque<>();
		List<Point> list = new ArrayList<Point>();

		que.add(start);
		list.add(start);

		int sum = map[start.x][start.y];

		while(!que.isEmpty()){
			Point curr = que.poll();
			visited[curr.x][curr.y] = true;
			for(int i=0;i<4;i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 유효하지 않은 좌표
				if(visited[nx][ny]) continue; // 이미 방문한 좌표라면

				int diff = Math.abs(map[curr.x][curr.y] - map[nx][ny]);
				if(diff < L || diff > R) continue; // 인구수의 차이

				isOpen = true; // 국경선이 한번 열림
				sum += map[nx][ny];
				list.add(new Point(nx,ny));
				visited[nx][ny] = true;
				que.add(new Point(nx,ny));
			}
		}
		if(!isOpen) return;

		sum = sum / list.size();
		for(Point point : list){
			map[point.x][point.y] = sum;
		}

	}
}