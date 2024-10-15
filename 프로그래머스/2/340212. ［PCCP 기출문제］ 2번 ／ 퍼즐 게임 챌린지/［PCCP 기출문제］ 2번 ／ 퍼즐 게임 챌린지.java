import java.util.*;

class Solution {
        static public int solution(int[] diffs, int[] times, long limit) {
        
        int answer = 0;
        int min = 1;
        int max = Arrays.stream(diffs).max().getAsInt();
        int mid = 0 ;

        while(min <= max){
            mid = (min + max) / 2;

            if(isSolve(mid,diffs,times,limit)) {
                answer = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return answer;
    }

    static boolean isSolve(int level,int[] diffs, int[] times, long limit){
        //숙련도가 정해져있다고 가정할때, 문제를 제한시간 내에 해결 할 수 있는가?

        long result = 0; // 소요시간

        int time_cur = 0;
        int time_prev = 0;

        for(int i=0;i< diffs.length;i++){
            time_cur = times[i];
            if(diffs[i] <= level) result += time_cur;
                //내 수준보다 쉬운 퍼즐일 경우
            else{
                int wrong = diffs[i] - level;
                result += ((time_cur + time_prev) * wrong + time_cur);
            }
            time_prev = time_cur;
        }

        return result <= limit;
    }
}