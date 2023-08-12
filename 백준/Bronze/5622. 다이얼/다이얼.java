import java.util.Scanner;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 *
 * @see https://www.acmicpc.net/problem/5622
 * @since 2023-08-10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String 문자 = sc.next();
        int 답 = 0;

        for(char 캐릭터:문자.toCharArray()){
            switch (캐릭터){
                case 'A' : case 'B' : case 'C':
                    답 += 3;
                    break;
                case 'D': case 'E' : case 'F':
                    답 += 4;
                    break;
                case 'G': case 'H' : case 'I':
                    답 += 5;
                    break;
                case 'J': case 'K' : case 'L':
                    답 += 6;
                    break;
                case 'M' : case 'N' : case 'O':
                    답 += 7;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    답 += 8;
                    break;
                case 'T': case 'U': case 'V':
                    답 += 9;
                    break;
                case 'W': case 'X': case 'Y': case  'Z':
                    답 += 10;
                    break;
                
            }

        }

        System.out.println(답);

    }
}