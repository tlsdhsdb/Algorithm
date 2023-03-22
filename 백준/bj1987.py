'''
dfs 1987 알파벳
'''

from sys import stdin

r,c = map(int,stdin.readline().split())
arr = []

dx = (-1,1,0,0)
dy = (0,0,-1,1)

visited = set() # 중복 제거

answer = 0

for _ in range(r):
    arr.append(list(input()))

def dfs(x,y,cnt):
    global answer
    answer = max(answer,cnt)
    #answer 값을 global로 저장하면서 가장 큰 depth를 저장함
    visited.add(arr[x][y])
    #크기 비교

    for i in range(4):
        #상하좌우 확인
        nx,ny = x + dx[i] , y + dy[i]
        if 0 <= nx < r and 0 <= ny < c:
            if arr[nx][ny] not in visited:
                # 방문하려는 노드를 이미 방문하지 않았을 경우에만
                dfs(nx,ny,cnt+1)
                # depth 더 들어감
    visited.remove(arr[x][y])

dfs(0,0,1)
print(answer)




