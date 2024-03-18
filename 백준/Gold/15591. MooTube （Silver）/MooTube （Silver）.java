import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 3/18/24
 **/
public class Main {
	static int Q,N;
	static int p,q,r;
	static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[5001];

		for(int i=0;i<5001;i++) list[i] = new ArrayList<>();

		for(int i=0;i<N-1;i++){
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[start].add(new int[]{end,value});
			list[end].add(new int[]{start,value});
		}

		for(int i=0;i<Q;i++){
			st = new StringTokenizer(br.readLine()," ");


			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N+1];
			visited[v] = true; // 시작점 방문
			Queue<Integer> que = new ArrayDeque<>();
			que.add(v);

			int ans = 0;
			while(!que.isEmpty()){
				int curr = que.poll();
				for(int[] a : list[curr]){
					if(!visited[a[0]] && a[1] >= k){
						que.add(a[0]); // 노드에 방문
						visited[a[0]] = true;
						ans++; // 방문한 노드의 개수만큼 추가
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}