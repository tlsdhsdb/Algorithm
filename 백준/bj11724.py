import sys
from sys import stdin
sys.setrecursionlimit(10000)

N,M = map(int,stdin.readline().split())
# 노드의 갯수 , 에지의 갯수

arr = [[] for _ in range(N+1)]
visited = [False] * (N+1)
#그래프를 담을 2차원 배열
#방문정보를 담은 boolean 배열

def DFS(v):
    visited[v] = True
    for i in arr[v]:
        if not visited[i]:
            #노드에 방문한적이 없다면
            DFS(i)

for _ in range(M):
    s,e = map(int,stdin.readline().split())
    arr[s].append(e)
    arr[e].append(s)
    #양방향 에지이기 때문에 양쪽에 에지를 더한다

count = 0

for i in range(1,N+1):
    #우리가 그래프를 표현한 방식의 경우 전체 노드만 순회해도 되기 때문에 loop 이용
    if not visited[i]:
        count += 1
        DFS(i)

print(count);




