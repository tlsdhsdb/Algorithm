'''
연결된 집의 모임 = 단지
단지수를 출력
각 단지에 속하는 집의 수를 오름차 순으로 정렬
'''
from collections import deque


dx,dy = [0,0,1,-1],[1,-1,0,0]

n = int(input())
graph = []

for _ in range(n):
    graph.append(list(int(i) for i in input()))

def bfs(node):
    que = deque([node])
    graph[node[0]][node[1]] = 0
    cnt = 1

    while que:
        x,y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                # 조건에 해당되지 않는 좌표는 넘긴다
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                que.append((nx,ny))
                cnt += 1
    return cnt

cnt = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            cnt.append(bfs((i,j)))
cnt.sort()
print(len(cnt))
for i in range(len(cnt)):
    print(cnt[i])

