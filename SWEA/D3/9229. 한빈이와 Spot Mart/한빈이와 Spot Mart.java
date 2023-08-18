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
 * @note 투포인터,데이터를 정렬을 한 뒤에 하면 계산을 하는 횟수가 감소함
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYlH3z4K78kDFAVR&contestProbId=AW8Wj7cqbY0DFAXN&probBoxId=AYnN7JhqMPoDFAUe&type=PROBLEM&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=3
 * @since 2023-08-08
 **/
public class Solution {
    static StringTokenizer st;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine()," ");

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);


            int right = arr.length-1;
            int left = 0;

            int max = -1;

            while(left < right){
                int hap = arr[right] + arr[left];

                if(hap > M){
                    right--;
                    continue;
                }
                //아예 큰 경우는 배제하기

                if(hap > max){
                    max = hap;
                    left++;
                    //right--;
                }else{
                    left++;
                }

            }

            System.out.println("#"+ (t+1)  + " " + max);

        }
    }
}