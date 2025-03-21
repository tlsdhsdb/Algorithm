import java.util.*;

class Solution {
    public int trap(int[] height) {

        if(height.length == 0) return 0;

        int volume = 0; // 결과값 (부피)
        int l = 0; int r = height.length - 1; // 각 벽의 인덱스
		int max_left = height[l] ; int max_right = height[r]; // 각 벽의 최대값

        while(l < r){
            // 투포인터 왼쪽의 인덱스가 오른쪽의 값과 같아지면 마무리한다
            max_left = Math.max(max_left,height[l]);
            max_right = Math.max(max_right,height[r]);

            if(max_left <= max_right){
                volume += max_left - height[l];
                l++;
            }else{
                volume += max_right - height[r];
                r--;
            }
        }

        return volume;

    }
}