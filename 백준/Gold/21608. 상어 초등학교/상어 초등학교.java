import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/21608
 * @since 2023-08-27
 **/
public class Main {
    static int N,sum; // 교실 크기, 만족도 총 합
    static int[] students; // 학생 배열
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}; // 상 우 하 좌
    static int[][] map; // 학생들이 앉은 map
    static Map<Integer, Set<Integer>> preferences; // 학생별 좋아하는 학생
    // contains() 함수로 좋아하는 사람이 있는지 찾을때,쉽게 찾기 위해 set 자료구조를 선택함


    public static void main(String[] args) throws Exception {

        init(); // 입력

        solution(); // 풀이

        printResult(); // 결과 출력

    }

    static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        sum = 0;
        map = new int[N][N];
        students = new int[N * N];
        preferences = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            // 학생 배열에 기록
            students[i] = student;
            // 학생별 좋아하는 학생들 기록
            preferences.put(student, new HashSet<>());
            for (int j = 0; j < 4; j++) {
                preferences.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
    }
    static void solution(){
        // 1. 학생들 자리 배치
        for(int i=0;i<students.length;i++){
            Seat seat = findSeat(students[i]); // 어디에 앉을지 찾고
            map[seat.x][seat.y] = students[i]; // 거기에 다시 정보를 넣음
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int count = getStudentSum(i,j,map[i][j]);
                if(count > 0) sum += (int)Math.pow(10,count-1);
                // 만족도가 10^n
            }
        }
    }
    static Seat findSeat(int student){
        Seat seat = null;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] > 0 ) continue; // 이미 누가 자리에 있으면 넘긴다
                Seat cur = new Seat(i,j,getStudentSum(i,j,student),getEmptySum(i,j));
                if(seat == null){
                    //비교할 좌석이 null 일 경우
                    seat = cur;
                    continue;
                }
                if(seat.compareTo(cur) > 0) seat = cur;
                // null 이 아니라면
            }
        }
        return seat;
    }
    static int getStudentSum(int x,int y,int student){
        // 인접한 좋아하는 학생 수
        int count = 0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(preferences.get(student).contains(map[nx][ny])) count++;
            // 좋아하는 학생이 포함되어있으면 증가
        }
        return count;
    }

    static int getEmptySum(int x,int y){
        int count = 0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(map[nx][ny] == 0) count++;
        }

        return count++;
    }
    static void printResult(){
        System.out.println(sum);
    }
    static class Seat implements Comparable<Seat>{
        int x,y;
        // 좌표
        int studentSum,emptySum;
        // 주변 좋아하는 학생 수
        // 주변 빈칸 수

        public Seat(int x, int y, int studentSum, int emptySum) {
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        //다른 좌석과 비교
        @Override
        public int compareTo(Seat o) {
            // 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
            // 비어있는 칸이 가장 많은 칸
            // 행의 번호가 가장 작은 칸
            // 양수일 경우, this가 크다
            // 음수일 경우, o가 크다

            // 근처에 좋아하는 학생수가 얼마나 있는지로 비교
            // 좋아하는 학생 수가 기존의 수와 다르다면, 계산한다
            // this.studentSum이 8이고 o.studentSum이 10이라고 하면
            // -2 라는 값이 나오게 되고, 우리는 비교하는 값, 즉 o를 비교했을때, 0 이상이 나오게 될 경우에만
            // 비교값을 넣어준다

            if(studentSum != o.studentSum) return -(studentSum - o.studentSum);

            // 인접 빈칸수로 비교
            if(emptySum != o.emptySum) return -(emptySum - o.emptySum);

            // 행으로 비교
            if(x != o.x) return x - o.x;

            // 열으로 비교
            return y - o.y;
        }
    }

}