import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/17406
 * @since 2023-08-10
 **/
public class Main {
    static int N,M,K;
    static int [][] arr;
    static int [][] rotate;
    static int [] numbers;
    static int [][] rotated_arr;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0;m<M;m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        rotate = new int[K][3];

        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine()," ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            rotate[k] = new int[] {r,c,s};

        }
        numbers = new int[K]; // 조합을 담을 배열

        for(int i=0;i<K;i++){
            numbers[i] = i;
        }

        do{
            int tmp = 0;
            for(int i=0;i< numbers.length;i++){
                int r = rotate[numbers[i]][0];
                int c = rotate[numbers[i]][1];
                int s = rotate[numbers[i]][2];

                int [][] tmp_arr;
                if(rotated_arr==null){
                    tmp_arr = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
                }else{
                    tmp_arr = rotated_arr;
                }

                rotation(r-s,r+s,c-s,c+s,tmp_arr);
            }
            for(int i=0;i<N;i++){
                Arrays.sort(rotated_arr[i]);
                tmp = Arrays.stream(rotated_arr[i]).sum();
                MIN = tmp < MIN ? tmp : MIN;
            }

            rotated_arr = null;

        }
        while(np(numbers));

        System.out.print(MIN);

    }
    private static boolean np(int[] p){
        // p : 다음 순열을 원하는 기존 순열의 배열
        // 1. 맨뒤부터 꼭대기 찾기
        int N = p.length;
        int i = N-1;

        while(i > 0 && p[i-1] >= p[i]) --i;
        //직전값이 같거나 크면, 오르막 형태

        //빠져 나오는 상황
        if( i == 0 ) return false; // 이미 절벽인 상태
        // 만들 수 있는 가장 큰 형태
        // 다음 순열이 없음

        // 2. 꼭대기 직전 (i-1) 위치에 교환할 한단계 큰 수 찾기 (뒤쪽부터 탐색)
        int j = N - 1;
        while(p[i-1] >= p[j]) --j; //아직 원하는 값을 찾지 못할 경우 j를 앞으로 땡김

        // 3. 꼭대기 직전 (i-1) 위치의 수와 한단계 큰 수를 교환하기
        swap(p,i-1,j);

        // 4. 꼭대기자리 부터 맨 뒤까지의 수를 오름차순의 형태로 바꿔줌
        int k = N-1;
        while(i<k) {
            swap(p,i++,k--); // 바꾸고 나면, i는 뒤로가고 k는 앞으로 옴
            //둘이 같은자리에 도달하고 나면 멈춤
        }

        return true;

    }
    private static void swap(int[] p,int a,int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }

    private static void rotation(int x,int nx,int y,int ny,int[][] copy){
        int [][] tmp = new int[N][M];
        //int [][] copy = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);

        if(x==nx && y==ny){
            rotated_arr = copy;
            return;
        }
        //rotation을 할 수 없는 크기 일 경우

        for(int i=y-1;i<ny-1;i++){
            //System.out.printf("(%d,%d)",x-1,i);
            tmp[x-1][i+1] = copy[x-1][i];
        }
        tmp[x][ny-1] = copy[x-1][ny-1];
        //오른쪽으로 돌리기

        for(int i=x-1;i<nx-1;i++){
            tmp[i+1][ny-1] = copy[i][ny-1];
        }
        tmp[nx-1][ny-2] = copy[nx-1][ny-1];
        //아래로 돌리기

        for(int i=ny-1;i>= y;i--){
            tmp[nx-1][i-1] = copy[nx-1][i];
            //System.out.printf("%d ",arr[nx-1][i]);
        }
        tmp[nx-2][y-1] = copy[nx-1][y-1];
        //왼쪽으로 돌리기

        for(int i=nx-2;i>=x;i--){
            tmp[i-1][y-1] = copy[i][y-1];
        }
        //위로 돌리기

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmp[i][j] != 0) copy[i][j] = tmp[i][j];
            }
        }

        rotation(x+1,nx-1,y+1,ny-1,copy);

    }
}