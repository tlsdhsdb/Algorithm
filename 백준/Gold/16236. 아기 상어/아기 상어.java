import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/16236
 * @since 2023/08/27
 **/
public class Main {
    static class Shark {
        int x, y;
        int size;

        public Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static class Fish implements Comparable<Fish> {
        int x, y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.distance == o.distance) {
                //거리가 같을 경우
                if (this.x == o.x) return this.y - o.y; // x축이 같을 경우
                return this.x - o.x; // 거리만 같을 경우
            }
            return this.distance - o.distance; // 거리가 같지 않을 경우
        }
        //먹을 수 있는 물고기가 1마리보다 많을 경우
        //거리가 가장 가까운 물고기를 먹는다
        //거리가 가까운 물고기가 많다면,가장 위에있는 물고기
        //가장 위에 있는 물고기가 많다면,가장 왼쪽에 있는 물고기

    }

    static int N;
    static int[][] map;
    static Shark shark;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int eat = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Shark(i, j, 2);
                }

            }
        }

        int time = 0;
        int cnt = 0;

        while (true) {
            Fish fish = bfs();
            if (fish == null) {
                break; // 먹을 물고기가 없을 경우
            } else {
                map[fish.x][fish.y] = 0; // 물고기를 먹어치운다
                shark.x = fish.x;
                shark.y = fish.y;
                //물고기를 먹어치운자리에 상어가 위치한다
                cnt++;
                time += fish.distance; // 물고기까지의 거리 = 시간
                if (cnt == shark.size) {
                    cnt = 0;
                    shark.size++;
                    //상어의 사이즈만큼 먹었다면, 사이즈를 크게 한다
                }
            }
        }
        System.out.println(time);

    }

    public static Fish bfs() {
        PriorityQueue<Fish> pq = new PriorityQueue<>(); // 물고기 저장을 위한 pq
        boolean[][] visited = new boolean[N][N]; // 방문배열
        Queue<Fish> que = new ArrayDeque<>();

        que.add(new Fish(shark.x, shark.y, 0));
        //상어의 위치를 큐에 넣는다
        visited[shark.x][shark.y] = true;

        while (!que.isEmpty()) {
            Fish fish = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (!visited[nx][ny] && map[nx][ny] <= shark.size) {
                    que.add(new Fish(nx, ny, fish.distance + 1));
                    visited[nx][ny] = true;
                    if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
                        //먹을 수 있는 물고기의 경우 우선순위 큐에 넣는다
                        pq.add(new Fish(nx, ny, fish.distance + 1));
                    }
                }
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        return pq.poll();
    }
}