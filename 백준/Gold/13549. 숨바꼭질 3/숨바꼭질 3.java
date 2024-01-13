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
 * @since 1/13/24
 **/
public class Main {
	static class Node{
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int MAX = 100000;

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;

		boolean[] visited = new boolean[MAX+1];
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(N,0));

		while(!que.isEmpty()){
			Node curr = que.poll();
			visited[curr.x] = true;

			if(curr.x == K) min = Math.min(min,curr.time);

			if(curr.x * 2 <= MAX && !visited[curr.x * 2]) que.add(new Node(curr.x * 2,curr.time));
			if(curr.x + 1 <= MAX && !visited[curr.x + 1]) que.add(new Node(curr.x + 1,curr.time + 1));
			if(curr.x - 1 >= 0 && !visited[curr.x - 1]) que.add(new Node(curr.x - 1,curr.time + 1));
		}

		System.out.println(min);
	}
}