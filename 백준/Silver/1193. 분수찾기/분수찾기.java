import java.util.Scanner;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 *
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