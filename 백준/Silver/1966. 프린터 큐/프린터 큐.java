import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 신온유
 * @performance
 * @category 구현
 * @note
 * @see https://www.acmicpc.net/problem/1966
 * @since 2023-08-10
 **/
public class Main {
    static int 문서의개수;
    static int 찾는문서;
    static Queue<문서> 문서큐;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int 테스트케이스 = Integer.parseInt(br.readLine());
        for(int t=0;t<테스트케이스;t++){
            st = new StringTokenizer(br.readLine()," ");

            문서의개수 = Integer.parseInt(st.nextToken());
            찾는문서 = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇번째에 놓여있는지
            문서큐 = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine()," ");

            for(int 문서번호=0;문서번호<문서의개수;문서번호++){
                문서큐.add(new 문서(문서번호,Integer.parseInt(st.nextToken())));
            }
            printer();

        }

    }
    static void printer(){
        int 인쇄순서 = 1; // 몇번째 인쇄

        while(!문서큐.isEmpty()){
            문서 가장큰문서 = Collections.max(문서큐);
            문서 현재문서 = 문서큐.poll();

            if(현재문서.equals(가장큰문서)){
                if (현재문서.문서번호 == 찾는문서) {
                    System.out.println(인쇄순서);
                    break;
                }
                인쇄순서++;
            }
            else{
                문서큐.offer(현재문서);
            }
        }
    }
    static class 문서 implements Comparable<문서>{
        int 문서번호;
        int 중요도;

        public 문서(int 문서번호, int 중요도){
            this.문서번호 = 문서번호;
            this.중요도 = 중요도;
        }

        @Override
        public int compareTo(문서 o) {
            return this.중요도 - o.중요도;
            //중요도 비교
            //중요도가 더 높으면 이긴다
        }
    }
}