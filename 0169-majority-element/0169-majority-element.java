class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int target = 0;
        int count = 0;
        int n = nums.length;

        for(int num : nums){
            if(num != target) {
                target = num;
                count+=1;
            }else{
                count +=1;
                if(count > n/2) break;
            }
        }
        return target;
    }
}