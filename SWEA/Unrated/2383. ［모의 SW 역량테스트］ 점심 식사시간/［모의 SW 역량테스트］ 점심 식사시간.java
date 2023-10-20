import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 시뮬레이션
 * 현재 위치에서 가장 가까운 계단의 위치를 먼저 찾고 -> 걸리는 시간을 계산한다
 * 계단의 길이가 짧으면서 가장 가까운 계단을 찾으면 된다.
 * 계단의 길이 + 거리 = 최소가 되어야 한다
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl
 * @since 2023-10-17
 **/
public class Solution {
    static int T,N,map[][],perIdx,min;
    static Person per[];
    static int stair[][];
    static class Person implements Comparable<Person>{
        int r,c,d,t;
        public Person(int r,int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Person o) {
            return d - o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc < T + 1; tc++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.valueOf(st.nextToken());
            per = new Person[N*N];
            int idx = 0;
            perIdx = 0;
            stair = new int[2][3]; // 세로 , 가로 , 길이
            map = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) per[perIdx++] = new Person(i,j);
                    if(map[i][j] >= 2){
                        stair[idx][0] = i;
                        stair[idx][1] = j;
                        stair[idx++][2] = map[i][j];
                    }
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0);
            System.out.println("#" + tc + " " + min);
        }
    }
    static void dfs(int idx){
        if(idx == perIdx){
            // 사람수만큼 골랏다면
            int max = 0;
            for(int i=0;i<2;i++){
                //0번계단으로 가는 사람과 1번계단으로 가는 사람을 나누어서 하기 위해 반복문을 사용함
                PriorityQueue<Person> pq = new PriorityQueue<>();
                int time[] = new int[100];
                for(int j=0;j<perIdx;j++){
                    if(per[j].t == i) pq.add(per[j]);
                }
                int end = 0;
                while(!pq.isEmpty()){
                    Person cur = pq.poll();
                    int start = cur.d; // 가장 계단과 가까운 사람의 거리값을 저장한다
                    end = start + stair[cur.t][2]; // 계단을 내려가는 시간을 계산하여 저장한
                    for(int j = start; j < end; j++){
                        if(time[j] == 3){
                            end++; // 3명 이상은 대기해야하니까
                            // 시간이 더 필요해
                            continue;
                        } // 한번에 3명까지 가능하니까 끝을 늘려
                        time[j]++;
                    } // 해당 시간대에 사용한 사람이 몇명인지 타임테이블을 만들어 줌

                    max = Math.max(max,end);
                    // 도착하는 시간이 큰 경우를 계속 저장함
                    // 도착하는 시간이 큰 경우가 제일 늦게 끝나는 시간일테니까
                }
            }
            min = Math.min(max,min);
            return;
        }
        per[idx].d = Math.abs(per[idx].r - stair[0][0]) + Math.abs(per[idx].c - stair[0][1]) + 1;
        per[idx].t =  0;
        dfs(idx + 1);
        // 0번 계단을 선택하는 경우

        per[idx].d = Math.abs(per[idx].r - stair[1][0]) + Math.abs(per[idx].c - stair[1][1]) + 1;
        per[idx].t = 1;
        dfs(idx + 1);
        // 1번 계단을 선택하는 경우
    }
}