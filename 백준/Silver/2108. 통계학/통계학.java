import java.util.*;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-08-10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] 수배열 = new int[N];
        HashMap<Integer,Integer> 최빈값저장맵 = new HashMap<>();

        int 산술평균 = 0;
        int 중앙값 = 0;
        int 최빈값 = 0;
        int 범위 = 0;
        double 합 = 0;

        for(int i=0;i<N;i++){
            int 입력 = sc.nextInt();
            수배열[i] = 입력;
            합 += 입력;
        }

        Arrays.sort(수배열);

        for(int 수 : 수배열){
            최빈값저장맵.put(수,최빈값저장맵.getOrDefault(수,1)+1);
        }

        int numbers = 0;
        for(int 값 : 최빈값저장맵.values()) numbers = Math.max(numbers,값);
        //가장 큰 최빈값을 찾음

        List<Integer> list = new ArrayList<>();

        for(int 값 : 최빈값저장맵.keySet()){
            if(numbers == 최빈값저장맵.get(값)) list.add(값);
        }

        Collections.sort(list);

        최빈값 = list.size() >= 2 ? list.get(1) : list.get(0);

        산술평균 = (int)Math.round(합 / N);
        중앙값 = 수배열.length >= 2 ? 수배열[수배열.length/2] : 수배열[0];

        범위 = 수배열.length >= 2 ? 수배열[수배열.length-1] - 수배열[0] : 0;


        System.out.println(산술평균);
        System.out.println(중앙값);
        System.out.println(최빈값);
        System.out.println(범위);




    }
}