import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
       
        int m = grid.length; int n = grid[0].length;
        int answer = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    //육지이면서 방문하지 않았다면
                    bfs(new int[]{i,j},grid,visited,m,n);
                    answer++;
                }
            }
        }

        return answer;
    }
    static void bfs(int[] start,char[][] grid,boolean[][] visited,int m,int n){
        
        Queue<int[]> que = new ArrayDeque<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0}; 
        visited[start[0]][start[1]] = true;
        que.add(start);

        while(!que.isEmpty()){
            int[] curr = que.poll();
            for(int i=0;i<4;i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] != '1') continue;
                visited[nx][ny] = true;
                que.add(new int[]{nx,ny});
            }
        }

    }
}