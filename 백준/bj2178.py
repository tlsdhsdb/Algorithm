'''
미로탐색
2차원 배열이 있을때, 지정된 위치로 이동할 때 지나야 하는 최소의 칸 수
최소탐색횟수 -> bfs
'''

from sys import stdin
from collections import deque


dx = [0,1,0,-1]
dy = [1,0,-1,0]

n,m = map(int,stdin.readline().split())
arr = [[0]*m for _ in range(n)] # Map 배열
visited = [[False] * m for _ in range(n)] # 방문한 노드 확인 하기

for i in range(n):
    numbers = list(input())
    for j in range(m):
        arr[i][j] = int(numbers[j])

# 데이터 입출력 부분

def bfs(i,j):
    que = deque()
    que.append((i,j))
    visited[i][j] = True

    while que:
        now = que.popleft()
        for k in range(4):
            x = now[0] + dx[k]
            y = now[1] + dy[k]
            # 상하좌우 확인하기
            if x >= 0 and y >= 0 and x < n and y < m:
                #유효한 좌표인지 확인하기
                if arr[x][y] != 0 and not visited[x][y]:
                    #0일 경우 가지 않음 and 이미 방문한 노드일 경우 가지 않음
                    visited[x][y] = True # 방문여부 표현
                    arr[x][y] = arr[now[0]][now[1]] + 1 # depth 올리기
                    que.append((x,y))


bfs(0,0)
print(arr[n-1][m-1])