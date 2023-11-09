import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo
 * @since 2023/11/08
 **/
public class Solution {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int T,N,max;
	static int[][] map;
	static Point[] dir = {
		new Point(0,1),
		new Point(0,-1),
		new Point(1,0),
		new Point(-1,0)
	};
	//오른쪽 왼쪽 아래 위
	static ArrayList<Point>[] warmHole;
	static Point start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int t=1;t<T+1;t++){

			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			warmHole = new ArrayList[11];
			for(int i=0;i<=10;i++) warmHole[i] = new ArrayList<>();
			// 최대 다섯쌍
			// 시작위치가 6이기 때문에 이것 고려해서 저장
			max = Integer.MIN_VALUE;

			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 5) {
						warmHole[map[i][j]].add(new Point(i,j));
					}
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j] == 0) {
						start = new Point(i,j);
						for (int d = 0; d < 4; d++) {
							go(i, j, d,0);
						}
					}
				}
			}

			System.out.printf("#%d %d\n",t,max);

		}
	}
	static void go(int x,int y,int d,int count){
		// x,y 시작점
		// d 방향
		int nx = x + dir[d].x ;
		int ny = y + dir[d].y;

		while(true){;
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				d = reverse(d);
				nx += dir[d].x;
				ny += dir[d].y;
				count++;
				continue;
			}//벽에 부딪히는 경우

			int next = map[nx][ny];

			if(next == -1 || (nx == start.x && ny == start.y)) {
				max = Math.max(max,count);
				break;
			}
			// 블랙홀에 들어가거나
			// 원래 위치로 돌아오게 되면 종료한다

			if(next > 0 && next <= 5){
				switch (next){
					case 1:
						if(d == 2|| d == 1){
							if(d == 2) d = 0;
							else d = 3;
						}
						else d = reverse(d);
						break;
					case 2:
						if(d == 3 || d == 1){
							if(d == 3) d = 0;
							else d = 2;
						}
						else d =reverse(d);
						break;
					case 3:
						if(d == 3 || d == 0){
							if(d == 3) d = 1;
							else d = 2;
						}
						else d = reverse(d);
						break;
					case 4:
						if(d == 2 || d == 0){
							if(d == 2) d = 1;
							else d = 3;
						}
						else d = reverse(d);
						break;
					case 5:
						d = reverse(d);
						break;
				}
				count++;
			}
			//블록에 부딪히는 경우

			if(next > 5){
				ArrayList<Point> p = warmHole[next];
				Point arrive= null;

				for(Point point : p){
					if(point.x == nx && point.y == ny) continue;
					arrive = point; // 이동 위치 저장
				}

				nx = arrive.x;
				ny = arrive.y;
			}
			//웜홀에 부딪히는 경우
			nx += dir[d].x;
			ny += dir[d].y;

		}
	}
	static int reverse(int d){
		if(d % 2 == 0) d++;
		else d--;
		return d;
	}
}