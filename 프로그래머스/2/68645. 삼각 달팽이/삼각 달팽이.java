class Solution {
    public int[] solution(int n) {
		int[] answer = {};

		int[][] arr = new int[n][n];

		int num = 1;
		int x = -1; int y = 0;

		for(int i=0;i<n;++i){
			for(int j=i;j<n;++j){
				if(i % 3 == 0){
					++x;
					//down
				}else if(i % 3 == 1){
					++y;
					// right
				}else{
					--x;
					--y;
					// 대각선
				}
				arr[x][y] = num++;
			}
		}

		answer = new int[num-1];
		int idx = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j] == 0) continue;
				answer[idx++] = arr[i][j];
			}
		}

		return answer;
	}
}