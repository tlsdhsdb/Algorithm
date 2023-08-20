import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/2630
 * @since 2023-08-10
 **/
public class Main {
    static int N;
    static int[][] paper;
    static int white,blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int nx = 0; nx < N; nx++){
            st = new StringTokenizer(br.readLine()," ");
            for(int ny = 0; ny < N; ny++){
                paper[nx][ny] = Integer.parseInt(st.nextToken());
            }
        }

        cuttingPaper(0,0,N);
        System.out.println(white);
        System.out.println(blue);


    }

    static void cuttingPaper(int x,int y,int size){ // 종이의 크기를 input

        if(colorCheck(x,y,size)){
            if(paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int n_size = size/2;


        cuttingPaper(x,y,n_size);
        cuttingPaper(x,y+n_size,n_size);
        cuttingPaper(x+n_size,y,n_size);
        cuttingPaper(x+n_size,y+n_size,n_size);

    }
    static boolean colorCheck(int x,int y,int size){
        int color = paper[x][y]; //기준이 되는 색

        for(int i = x;i < x + size;i++){
            for(int j = y;j < y + size;j++){
                if(color != paper[i][j]) return false;
            }
        }
        return true;
    }
}