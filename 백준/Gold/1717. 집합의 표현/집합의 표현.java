import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note 유니온 파인드 알고리즘을 학습해보자
 * 유니온은 두개의 원소 a,b가 있다고 가정해보자 각각의 원소를 포함하고 있는 집합을 합치는 연산이다.
 * 파인드는 주어진 원소의 대표노드를 찾는 연산이다
 * 해당 문제에서 원하는 연산은 두가지이다.
 * 1.합집합 연산
 * 2.두 원소가 같은 집합에 포함되었는지 여부를 확인하는 연산
 * 합집합의 경우, 유니온 연산을 하면 되고
 * 두 원소의 동집합 포함여부는 파인드 연산을 통해, 대표노드를 찾은뒤 같은지 비교만 하면 된다.
 * @see https://www.acmicpc.net/problem/1717
 * @since 2023/09/14
 **/
public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];

        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0){
                union(parent,a,b);
                //합집합
            }else{
                //포함여부 확인
                if(checkSame(parent,a,b)) System.out.println("YES");
                else System.out.println("NO");
            }

        }
    }
    static void union(int[] parent,int a,int b){
        a = find(parent,a); // a의 부모를 찾는다
        b = find(parent,b); // b의 부모를 찾는다

        if(a!=b){
            //둘이 부모가 다르면 합친다
            parent[b] = a;
            //b의 부모를 a의 부모값으로 변경한다
            //합친다
        }
    }
    static int find(int[] parent,int a){
        // a의 부모를 찾는 연산
        if(a == parent[a]){
            // 자기자신을 가리키고 있는 노드라면
            return a;
        }else{
            parent[a] = find(parent,parent[a]);
            return parent[a];
        }
    }

    static boolean checkSame(int[] parent,int a,int b){
        a = find(parent,a);
        b = find(parent,b);
        // 각자의 부모를 찾은다음

        if(a==b) return true;
        else return false;

    }
}