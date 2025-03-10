import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";

		HashMap<String,Integer> map = new HashMap<>();

		for(String participant : participants) map.put(participant,map.getOrDefault(participant,0)+1);
		for(String completion : completions) {
			if(map.containsKey(completion)){
				if(map.get(completion) - 1 == 0) map.remove(completion);
				else map.put(completion,map.get(completion) - 1);
			}
		}

		answer = map.keySet().toArray()[0].toString();
        return answer;
    }
}