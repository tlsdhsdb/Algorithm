'''
bfs & dfs
방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문
방문 할 점이 없는 경우 종료

'''

from sys import stdin
from collections import deque

n,m,v = map(int,stdin.readline().split())
arr = [[] for i in range(n+1)]
visited_dfs = [False] * (n+1)
visited_bfs = [False] * (n+1)


answer_dfs = []
answer_bfs = []

for _ in range(1,m+1):
    idx,value = map(int,stdin.readline().split())
    arr[idx].append(value)
    arr[value].append(idx)

for i in range(n+1):
    arr[i].sort()

def dfs(node):
    visited_dfs[node] = True
    answer_dfs.append(node)
    for i in arr[node]:
        if not visited_dfs[i]:
            dfs(i)

def bfs(node):
    que = deque()
    que.append(node)
    visited_bfs[node] = True
    while que:
        now_node = que.popleft()
        answer_bfs.append(now_node)
        for i in arr[now_node]:
            if not visited_bfs[i]:
                visited_bfs[i] = True
                que.append(i)



dfs(v)
bfs(v)

print(*answer_dfs)
print(*answer_bfs)
