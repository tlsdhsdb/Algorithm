public class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // 새로운 후보 선택
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}