import java.util.Scanner;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 시간제한이 0.5초로 매우 짧다,이럴경우 for문을 전체 순회하지 말라는 뜻과 같다
 * 지그재그로 배열을 왔다갔다 하는데,이 경우 몇번째 depth에 해당 숫자가 위치하는지만 알면
 * 전체를 순회 할 필요가 없다
 * 전체를 순회하지 않기 위해 해당 수가 몇번째 depth에 위치하는 지 알아낸 뒤
 * 해당 depth에서 우리가 원하는 수를 찾을때까지만 loop를 돈다
 * @see https://www.acmicpc.net/problem/1193
 * @since 2023-08-10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int 숫자 = sc.nextInt();
        int 깊이 = 1;
        int 합계 = 0;


        while(true){
            if(합계 >= 숫자) break;
            합계 += 깊이;
            깊이 ++;
        }

        깊이-= 1;
        합계 -=  깊이 - 1;



        for(int i = 0;i<깊이;i++){

            if(합계 == 숫자){
                if(깊이 % 2 == 1) System.out.printf("%d/%d \n",깊이-i,i + 1);
                else System.out.printf("%d/%d \n",i + 1,깊이-i);
                break;
            }
            else 합계++;
        }

    }
}