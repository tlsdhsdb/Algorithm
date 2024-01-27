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
		int x,y,z;
		int time;

		public Point(int x, int y, int z, int time) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while(true){
			st = new StringTokenizer(br.readLine()," ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if(L == 0 && R == 0 && C == 0) break;

			int[] dz = {0,0,0,0,1,-1};
			int[] dx = {0,0,1,-1,0,0};
			int[] dy = {1,-1,0,0,0,0};

			boolean isEscape = false;

			char[][][] map = new char[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];

			Queue<Point> que = new ArrayDeque<>();

			for(int l=0;l<L;l++){
				for(int r=0;r<R;r++){
					String line = br.readLine();
					for(int c=0;c<C;c++){
						map[l][r][c] = line.charAt(c);
						if(map[l][r][c] == 'S') que.add(new Point(r,c,l,0));
					}
				}
				br.readLine();
			}

			while(!que.isEmpty()){
				Point curr = que.poll();
				visited[curr.z][curr.x][curr.y] = true;

				if(map[curr.z][curr.x][curr.y] == 'E'){
					isEscape = true;
					sb.append("Escaped in "+ curr.time + " minute(s).\n");
					break;
				}

				for(int i=0;i<6;i++){
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];
					int nz = curr.z + dz[i];

					if(nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
					if(visited[nz][nx][ny]) continue;
					if(map[nz][nx][ny] == '#') continue; // 벽은 지나갈 수 없습니다

					visited[nz][nx][ny] = true;
					que.add(new Point(nx,ny,nz,curr.time+1));
				}

			}
			if(!isEscape) sb.append("Trapped!\n");
		}
		System.out.println(sb);
	}
}