import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int T,W,H;
	static Queue<Point> que;
	static Point start; // 출발지점
	static int result;
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		T = Integer.parseInt(st.nextToken());

		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine()," ");

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			result = 0;

			map = new char[H][W];
			que = new ArrayDeque<>();

			for(int h=0;h<H;h++){
				map[h] = br.readLine().toCharArray();
			}

			for(int h=0;h<H;h++){
				for(int w=0;w<W;w++){
					if(map[h][w] == '*') que.add(new Point(h,w));
					else if(map[h][w] == '@') start = new Point(h,w);
				}
			}

			que.add(start);
			sb.append(simulation() ? result : "IMPOSSIBLE").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	public static boolean simulation(){
		while(!que.isEmpty()){
			result++;
			for(int i=0,size = que.size();i<size;i++){
				Point curr = que.poll();
				for(int j=0;j<4;j++){
					int nx = curr.x + dx[j];
					int ny = curr.y + dy[j];

					if(nx < 0 || nx >= H || ny < 0 || ny >= W){
						if(map[curr.x][curr.y] == '@') return true;
						// 탈출 성공
						continue;
					}
					if(map[nx][ny] != '.') continue; // 빈공간이 아니라면 넘어간다
					map[nx][ny] = map[curr.x][curr.y]; // 불이거나 사람일 경우,이동시킨다
					que.add(new Point(nx,ny));
				}
			}
		}
		return false;
	}
}