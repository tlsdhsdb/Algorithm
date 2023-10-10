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
 * @since 2023/10/09
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
        Point point;
        int c,p; // 충전범위 처리량

        public Charger(Point point, int c, int p) {
            this.point = point;
            this.c = c;
            this.p = p;
        }
    }
    static int T;
    static int M,A;
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};

    static int[] userA,userB;
    static Point a,b;
    static Charger[] chargers;
    static int answer;

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

            chargers = new Charger[A];

            st = new StringTokenizer(br.readLine()," ");
            for(int time=1;time<=M;time++){
                userA[time] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");
            for(int time=1;time<=M;time++){
                userB[time] = Integer.parseInt(st.nextToken());
            }

            for(int a=0;a<A;a++){
                st = new StringTokenizer(br.readLine()," ");
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()); // 충전범위
                int p = Integer.parseInt(st.nextToken()); // 처리량

                chargers[a] = new Charger(new Point(x,y),c,p); // 좌표가 반대이기 때문에 반대로

            }

            a = new Point(0,0);
            b = new Point(9,9);

            answer = 0;

            for(int i=0;i<M+1;i++){
                a.x += dx[userA[i]];
                a.y += dy[userA[i]];
                b.x += dx[userB[i]];
                b.y += dy[userB[i]];

                answer += charge();
            }
            //매시간마다 충전하는 것을 시뮬레이션

            System.out.printf("#%d %d \n",t,answer);
        }
    }

    static int charge(){
        //완전탐색
        //모든 경우의 수를 탐색한다
        int max = 0;
        for(int i=0;i<A;i++){

            for(int j=0;j<A;j++){
                int sum = 0;
                int amountA = isCharge(a,chargers[i]);
                int amountB = isCharge(b,chargers[j]);

                if(i != j) sum = amountA + amountB; //다른 충전소를 사용하는 경우
                else sum = Math.max(amountA,amountB); // 같은 충전소를 사용하는 경우 큰값을 저장한다
                // 같은 충전소를 사용하면 반토막이 나기 때문에,최댓값을 구하기 위해서는 큰 값만 저장한다

                max = Math.max(sum,max);

            }
        }
        return max;
    }

    static int isCharge(Point player,Charger charger){
        return Math.abs(player.x-charger.point.x) + Math.abs(player.y-charger.point.y) <= charger.c ? charger.p : 0 ;
        //충전 범위 안으로 들어오면 해당량만큼 처리 가능하다
    }
    //충전 가능여부를 체크하는 함수
}
