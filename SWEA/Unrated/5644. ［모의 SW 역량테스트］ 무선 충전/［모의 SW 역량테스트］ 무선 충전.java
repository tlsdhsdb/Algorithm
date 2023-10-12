import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note https://diane21.tistory.com/35 참고하기
 * "최댓값"
 * 하나의 충전기를 두명이 사용할 수 있음
 * 매 위치마다의 두명 합의 최대값을 구해야한다
 * 구해야하는 것에 집중하기
 *
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&
 * @since 2023/10/12
 **/
public class Solution {
    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Charger{
        Point dir;
        int c,p; // 충전 범위, 처리량

        public Charger(Point dir, int c, int p) {
            this.dir = dir;
            this.c = c;
            this.p = p;
        }
    }
    static int T;
    static int M,A; // M 이동시간 A 충전기의 개수
    static int[] userA,userB;
    static Point a,b; // 유저 a,b 시작지점
    static Charger[] chargers;
    static int answer;
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            userA = new int[M+1];
            userB = new int[M+1];

            a = new Point(0,0);
            b = new Point(9,9);

            chargers = new Charger[A];

            st = new StringTokenizer(br.readLine()," ");
            for(int m=1;m<M+1;m++){
                userA[m] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");
            for(int m=1;m<M+1;m++){
                userB[m] = Integer.parseInt(st.nextToken());
            }
            //유저 이동 정보 입력

            for(int a=0;a<A;a++){
                st = new StringTokenizer(br.readLine()," ");
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers[a] = new Charger(new Point(x,y),c,p); // 좌표계가 반대이기 때문에 변경해줌
            }//충전기 입력

            answer = 0;

            for(int i=0;i<M+1;i++){
                // 0초부터 시작하기 때문에
                a.x += dx[userA[i]];
                a.y += dy[userA[i]];

                b.x += dx[userB[i]];
                b.y += dy[userB[i]];

                answer += charge(); // 이동할때마다 최대값 구하기
            }

            System.out.printf("#%d %d\n",t,answer);
        }
    }

    static int charge(){
        int max = 0;
        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                int sum = 0;
                int amountA = isCharge(a,chargers[i]);
                int amountB = isCharge(b,chargers[j]);

                if(i != j) sum = amountA + amountB;
                else sum = Math.max(amountA,amountB);

                max = Math.max(max,sum); // 큰 값으로 계속 초기화 해주기
            }
        }
        return max;
    }
    static int isCharge(Point player,Charger charger){
        return Math.abs(player.x-charger.dir.x) + Math.abs(player.y - charger.dir.y) <= charger.c ? charger.p : 0;
        //충전기 범위 안으로 들어오면 충전하고 , 그렇지 않으면
    }
}