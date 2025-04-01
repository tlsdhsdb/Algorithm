import java.util.*;

class Solution {
    int answer = 0;
    int[][] q;
    int[] ans;
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans  = ans;
        boolean[] number = new boolean[n+1];
        Arrays.fill(number,true);
        
        for(int i=0;i<ans.length;i++){
            if(ans[i] == 0){
                //해당 숫자는 지워야 함
                for(int j=0;j<q[i].length;j++) number[q[i][j]] = false;
            }
        }
        
        List<Integer> pool = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(number[i]) pool.add(i);
        }
        
        combination(new ArrayList<>(),pool,0);    
        
        return answer;
    }
    
    void combination(List<Integer> current, List<Integer> pool,int idx){
        if(current.size() == 5){
            if(isValid(current)) answer++;
            return;
        }
        if(idx >= pool.size()) return;
        //더이상 선택할 숫자가 없을 때 종료한다
        
        current.add(pool.get(idx));
        combination(current,pool,idx+1);
        current.remove(current.size()-1);
        
        // 선택하고 다시 빼기 
        
        combination(current,pool,idx+1);
        
        // 선택안하기
    }
    
    boolean isValid(List<Integer> selected){
        //System.out.println(selected.toString());
        for(int i=0;i<q.length;i++){
            int count = 0;
            for(int num : selected){
                for(int x : q[i]){
                    if(num == x) count++;
                }
            }
            if(count != ans[i]) return false;
        }
        
        //조건에 부합여부를 확인한다
        return true;
    }
    
}