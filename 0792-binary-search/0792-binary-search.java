class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int k = nums.length;
        int j = 0;

        while(i < k){
            j =  (i + k)/2;

            if(nums[j] < target) i = j + 1;
            if(nums[j] > target) k = j ;
            if(nums[j] == target) break;
        }

        return nums[j] == target ? j : -1;
    }
}