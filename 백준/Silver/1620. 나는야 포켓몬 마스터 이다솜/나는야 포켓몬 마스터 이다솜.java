import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/1620
 * @since 2023-10-23
 **/
public class Main {
    static HashMap<String,Integer> map1;
    static HashMap<Integer,String> map2;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        for(int i=1;i<n+1;i++){
            String name = br.readLine();
            map1.put(name,i);
            map2.put(i,name);
        }

        for(int i=0;i<m;i++) {
            // 문제 시작
            String q = br.readLine();
            String answer = "";
            if (isNumeric(q)) {
                // 숫자라면
                answer = map2.get(Integer.parseInt(q));

            } else {
                // 이름이라면
                answer = String.valueOf(map1.get(q));
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
    static boolean isNumeric(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}