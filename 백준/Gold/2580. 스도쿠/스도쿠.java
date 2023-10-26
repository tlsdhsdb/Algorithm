import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * https://www.acmicpc.net/problem/2580
 * @since 2023-10-26
 **/
public class Main {
    static class Point{
        int x,y,value;

        public Point(int x, int y,int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int[][] map;
    static ArrayList<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[9][9];
        points = new ArrayList<>();
        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) points.add(new Point(i,j,0));
            }
        }
        dfs(0);
    }

    static void dfs(int depth){
        if(depth == points.size()){
            //0의 개수만큼 루프를 돌았다면
            //스도쿠 확인
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);

        }
        Point p = points.get(depth);
        for(int i=1;i<10;i++) {
            if(validation(new Point(p.x,p.y,i))) {
                map[p.x][p.y] = i;
                dfs(depth + 1);
                map[p.x][p.y] = 0;
            }
        }
    }

    static boolean validation(Point point){
        int col = point.x;
        int row = point.y;
        int value = point.value;

        //해당 지점이 유효한지 테스트한다

        for(int i=0;i<9;i++){
            if(map[col][i] == value) return false;
        }

        for(int i=0;i<9;i++){
            if(map[i][row] == value) return false;
        }

        int nCol = (col / 3) * 3;
        int nRow = (row / 3) * 3;

        for(int i=nCol;i<nCol+3;i++){
            for(int j=nRow;j<nRow+3;j++){
                if(map[i][j] == value) return false;
            }
        }

        return true;
    }
}