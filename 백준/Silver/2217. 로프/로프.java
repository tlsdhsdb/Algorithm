import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
    * 로프를 병렬로 연결해서 각각의 로프에 걸리는 중량을 나누어보자
    * k개의 로프를 이용하여 w인 물체를 들어올릴때 각각의 로프는  w/k의 하중
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }

        Arrays.sort(arr); //중량별 정렬

        long max = 0;
        //최대 중량이 제일 큰 로프순으로 꺼내면서 순서대로 병렬로 연결한다 
        for(int i = n-1;i >=0;i--){
            arr[i] = arr[i] * (n - i);
            if(max < arr[i]) max = arr[i];
            //최대 중량을 확인하며 큰 값만 저장한다.
        }

        System.out.println(max);

    }
}