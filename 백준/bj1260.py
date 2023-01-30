from sys import stdin
from collections import deque

n, m, v = map(int, stdin.readline().split())

# 노드개수,에지개수,시작점

arr = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(1, m + 1):
    start, end = map(int, stdin.readline().split())
    arr[start].append(end)
    arr[end].append(start)

for i in range(n+1):
    arr[i].sort() #정렬

def dfs(node):
    global arr
    print('now',node)
    visited[node] = True
    print(node)
    for n in arr[node]:
        if not visited[i]:
            dfs(n)

visited = [False] * (n+1) # visited 배열 초기화
dfs(v)

def bfs(node):
    global arr
    que = deque()
    que.append(node)
    visited[node] = True
    while que:
        now = que.popleft()
        print('now:',now)
        for i in arr[now]:
            if not visited[i]:
                visited[i] = True
                que.append(i)

bfs(v)

