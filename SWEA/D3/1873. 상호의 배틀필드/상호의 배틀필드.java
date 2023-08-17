import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-08-17
 **/
public class Solution {
    static char 지도[][];
    static int[][] 방향배열 = {{-1,0},{0,1},{1,0},{0,-1}};
    // ^ > v <
    static int 높이;
    static int 너비;

    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int 테스트케이스 = Integer.parseInt(br.readLine());


        for(int 테스트 = 1; 테스트 <= 테스트케이스 ; 테스트++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine()," ");
            높이 = Integer.parseInt(st.nextToken());
            너비 = Integer.parseInt(st.nextToken());
            지도 = new char[높이][너비];

            for(int h = 0; h < 높이; h++){
                String 입력 = br.readLine();
                for(int w = 0; w < 너비; w++){
                    if(입력.charAt(w) == '^' || 입력.charAt(w) == '>' || 입력.charAt(w) == 'v' || 입력.charAt(w) == '<'){
                        x = h;
                        y = w;
                    }
                    지도[h][w] = 입력.charAt(w);
                }
            }

            int 명령어개수 = Integer.parseInt(br.readLine());

            String 명령어입력 = br.readLine();

            for(int i=0;i<명령어개수;i++){
                전차이동(명령어입력.charAt(i));
            }

            sb.append("#"+테스트+" ");
            for(int h=0;h<높이;h++){
                for(int w=0;w<너비;w++){
                    sb.append(지도[h][w]);
                }
                sb.append("\n");
            }
            System.out.print(sb);

            //지도 = null;
        }

    }
    static void 전차이동(char 명령어){

        switch (명령어){

            case 'U':
                if(x-1 >= 0 && 지도[x-1][y] == '.' ){
                    지도[x][y] = '.';
                    지도[--x][y] = '^';
                }else{
                    지도[x][y] = '^';
                }
                break;
            case 'D':
                if(x+1 < 높이 && 지도[x+1][y] == '.' ){
                    지도[x][y] = '.';
                    지도[++x][y] = 'v';
                }else{
                    지도[x][y] = 'v';
                }
                break;
            case 'L':
                if(y-1 >= 0 && 지도[x][y-1] == '.' ){
                    지도[x][y] = '.';
                    지도[x][--y] = '<';
                }else{
                    지도[x][y] = '<';
                }
                break;
            case 'R':
                if(y+1 < 너비 && 지도[x][y+1] == '.' ){
                    지도[x][y] = '.';
                    지도[x][++y] = '>';
                }else{
                    지도[x][y] = '>';
                }
                break;
            case 'S':
                char 방향 = 지도[x][y];
                int 방향인덱스 = -1;
                switch (방향){
                    case '^':
                        방향인덱스 = 0;
                        break;
                    case '>':
                        방향인덱스 = 1;
                        break;
                    case 'v':
                        방향인덱스 = 2;
                        break;
                    case '<':
                        방향인덱스 = 3;
                        break;
                }
                int nx = x + 방향배열[방향인덱스][0];
                int ny = y + 방향배열[방향인덱스][1];

                while(true){
                    if(nx < 0 || nx >= 높이 || ny < 0 || ny >= 너비) break;
                    //아무런 일도 발생하지 않는다

                    if(지도[nx][ny] == '*'){
                        지도[nx][ny] = '.';
                        //벽돌에 부딪힌 경우
                        break;
                    }else if(지도[nx][ny] == '#') break;
                    //강철 벽돌에 부딪힌 경우

                    nx += 방향배열[방향인덱스][0];
                    ny += 방향배열[방향인덱스][1];
                }

        }
    }
}