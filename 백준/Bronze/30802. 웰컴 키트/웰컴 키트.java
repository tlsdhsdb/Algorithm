import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 6개의 사이즈 -> 같은 사이즈 T장 묶음
 * P 자루씩 묶음 or 한자루씩
 * @see
 * @since 7/4/24
 **/
public class Main {
	static int N,T,P;
	static int[] size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		size  = new int[6];

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<6;i++){
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine()," ");
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		int p1,p2 = 0;

		p1 = N / P;
		p2 = N % P;

		int t = 0;
		for(int s : size){
			if(s % T == 0){
				t += s / T;
			}else if(s % T > 0){
				t += s / T + 1;
			}
		}

		System.out.println(t);
		System.out.println(p1 + " " + p2);

	}
}