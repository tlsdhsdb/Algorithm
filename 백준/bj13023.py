import sys
from sys import stdin

sys.setrecursionlimit(10000)
N,M = map(int,stdin.readline().split())

arr = [[] for _ in range(N+1)]
visited = [False] * (N+1)
arrive = False

def dfs(now,depth):
    global arrive

    if depth == 5:
        arrive = True
        #원하는 depth 에 도착하면 그만 순회함
        return
    visited[now] = True
    for value in arr[now]:
        if not visited[value] :
            dfs(value,depth+1)
            # 재귀호출때마다 depth가 1증가
    visited[now] = False
    #재귀호출에서 빠져나올때,현재 재귀보다 더 긴 루트가 있을 수도 있기 때문에 false 처리를 해놓는다
    # True가 되어있으면 순회를 안하니까

for _ in range(M):
    a,b = map(int,stdin.readline().split())
    arr[a].append(b)
    arr[b].append(a)
    #양방향 저장

#인덱스가 정점, value가 정점에 연결된 값

for i in range(N):
    dfs(i,1)
    if arrive:
        break

if arrive:
    print(1)
else :
    print(0)