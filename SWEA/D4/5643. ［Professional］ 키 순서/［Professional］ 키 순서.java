import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/11/17
 **/
public class Solution {
	static int T,N,M;
	static ArrayList<Integer>[] list1,list2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<T+1;t++){
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());

			list1 = new ArrayList[N+1];
			list2 = new ArrayList[N+1];

			for(int n=0;n<N+1;n++){
				list1[n] = new ArrayList<>();
				list2[n] = new ArrayList<>();
			}


			int count = 0;
			for(int m=0;m<M;m++){
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				list1[start].add(end);
				list2[end].add(start);
			}

			for(int i=1;i<N+1;i++){
				boolean[] v1 = dfs(i,new boolean[N+1],list1);
				boolean[] v2 = dfs(i,new boolean[N+1],list2);

				int a = 0;
				int b = 0;
				for(int j=1;j<N+1;j++){
					if(i!=j){
						if(v1[j]) a++;
						if(v2[j]) b++;
					}
				}

				if(a + b == N-1) count++;
			}
			System.out.printf("#%d %d\n",t,count);
		}
	}
	static boolean[] dfs(int start,boolean[] visited, ArrayList<Integer>[] list){
		visited[start] = true;
		for(int value : list[start]){
			if(visited[value]) continue;
			visited[value] = true;
			dfs(value,visited,list);
			//visited[value] = false;
		}
		return visited;
	}
}