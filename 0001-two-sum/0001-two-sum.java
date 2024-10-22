import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 이미 차이값이 map에 있으면 정답을 반환
            
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result; // 정답을 찾았으므로 바로 반환
            }
            
            // 현재 값을 차이값을 key로, 인덱스를 value로 저장
            map.put(complement, i);
        }
    
        return result;
    }
}