import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int x = image.length;
        int y = image[0].length;
        
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[x][y];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int target = image[sr][sc];

        que.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int curx = curr[0];
            int cury = curr[1];

            for(int i=0;i<4;i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
                if(image[nx][ny] == color) continue; // 이미 해당 컬러인 경우 방문했기 때문에 더이상 가지 않음
                if(image[nx][ny] != target) continue; // 시작 컬럼과 같은 색깔이 다를 경우에는 가지 않음
                
                
                image[nx][ny] = color;
                que.add(new int[]{nx,ny});
            }
        }

        return image;
    }
}