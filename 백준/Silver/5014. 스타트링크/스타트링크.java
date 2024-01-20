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
 * @since 1/20/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int F,S,G,U,D = 0;

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int[] move = new int[]{U,-D};
		int answer = Integer.MAX_VALUE;

		Queue<int[]> que = new ArrayDeque<>();
		boolean[] visited = new boolean[F+1];

		que.add(new int[]{S,0});
		visited[S] = true;

		while(!que.isEmpty()){
			int[] curr = que.poll();
			int floor = curr[0]; // 현재 층
			int count = curr[1]; // 몇번을 눌렀는지

			if(floor == G) answer = Math.min(count,answer);

			for(int m : move){
				int f = floor + m;

				if(f <= 0 || f > F) continue;
				if(visited[f]) continue;

				visited[f] = true;
				que.add(new int[]{f,count+1});
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);

	}
}