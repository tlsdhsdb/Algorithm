import java.io.*;
import java.util.ArrayList;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note 보이는데로 구현하기
 * 스도쿠의 성질은 다음과 같다.
 * 1. 현재칸을 포함하고 있는 가로줄에 중복없이 1-9사이의 숫자가 들어차있다
 * 2. 현재칸을 포함하고 있는 세로줄에 중복없이 1-9사이의 숫자가 들어차있다.
 * 3. 현재칸을 포함하고 있는 3 * 3 사각형에 1-9 사이의 숫자가 들어차있다.
 * 이 로직을 구현하고 나면,여기에 허용되는 숫자만 넣어주는 반복작업을 하면 된다
 * @see https://www.acmicpc.net/problem/2239
 * @since 2023-09-26
 **/
public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board = new int[9][9];
    static boolean end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0;j<9;j++) {
                board[i][j] = Integer.parseInt(String.valueOf(arr[j]));
            }
        }
        sudoku(0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public static void sudoku(int depth) {
        if(81 == depth) {
            end = true;
            return;
        }

        int x = depth / 9;
        int y = depth % 9;

        if(board[x][y] != 0) sudoku(depth+1);
        else{
            for(int i=1;i<10;i++){
                if(!isPossible(new Point(x,y),i)) continue;
                board[x][y] = i;
                sudoku(depth+1);
                if(end) return; // 종료조건을 충족하면 프로그램을 종료한다
                board[x][y] = 0;
            }
        }
    }
    public static boolean isPossible(Point p,int value){
        // col 확인
        for(int i=0;i<9;i++) if(board[p.x][i] == value) return false; // 하나라도 같은게 있다면 false

        // row 확인
        for(int i=0;i<9;i++)  if(board[i][p.y] == value) return false; // 하나라도 같은게 있다면 false

        // 사각형 확인
        int start = 3 * (p.x / 3);
        int end = 3 * (p.y / 3);

        for(int i = start; i < start + 3; i++) {
            for (int j = end; j < end + 3; j++) {
                if (board[i][j] == value) return false; // 하나라도 같은게 있다면 false
            }
        }

        return true; // 여기까지 무사히 왔으면 true
    }
}