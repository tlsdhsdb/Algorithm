import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author onyoo
 * @performance
 * @category
 * @note 총 숫자가 1만개이기 때문에,함수를 통해 하나씩 확인해보는 for문이 가능하다.
 * 판독기를 통해 나온 숫자가 있다면,나온 숫자는 생성자를 가지고 있는 것이기 때문에 셀프넘버가 될 수 없다
 * @see https://www.acmicpc.net/problem/4673
 * @since 2023-08-10
 **/
public class Main {
    static boolean[] 셀프넘버 = new boolean[10001];
    //셀프넘버 1만개를 담을 boolean 배열을 준비한다
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1;i<=10000;i++){
            int 숫자 = 셀프넘버판독기(i); //판독기를 통해 나온 숫자는 셀프넘버가 될 수 없다
            if(숫자 < 10001) 셀프넘버[숫자] = true;
        }

        for(int i=1;i<=10000;i++){
            if(!셀프넘버[i]) bw.write( i + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int 셀프넘버판독기(int 숫자){
        int 합 = 숫자;

        while(숫자 != 0){

            합 += 숫자 % 10;
            숫자 = 숫자 / 10;

        }

        return 합;

    }
}