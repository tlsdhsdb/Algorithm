import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * DP : 1차원 배열 , 해당 인덱스 길이의 숫자까지 왔을 때 가장 긴 수열의 길이를 저장
 * N의 크기가 1,000,000 으로 크다 -> 최적화 필요함 O(logN)의 시간 복잡도를 가지는 방법을 사용해야한다
 * 배열의 끝점이 최소가 되도록 유지해야한다
 * 배열의 끝점이 최소가 된다 -> 이후로 더 많은 수를 받을 수 있다.
 * 끝점이 커져버리게 되면, 이것보다 작은 숫자들은 못받기 때문에 !
 * https://buyandpray.tistory.com/73 (참고)
 * @see https://www.acmicpc.net/problem/11053
 * @since 2023-10-25
 **/
public class Main {
    static int N;
    static int[] seq,lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        lis = new int[N];


        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = seq[0];
        int length = 1; // lis의 길이

        for(int i=1;i<N;i++){
            
            int key = seq[i];
            
            if(lis[length-1] < key){
                length++;
                lis[length-1] = key;
            }
            else{
                //이전것보다 더 작은게 나온다면
                int low = 0;
                int high = length;
                while(low < high){
                    int mid  = (low + high) >>> 1;
                    if(lis[mid] < key){
                        low = mid + 1;
                    }else{
                        high = mid;
                    }
                }
                lis[low] = key;
            }
        }

        System.out.println(length);

    }

}