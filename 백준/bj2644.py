'''
촌수 계산 2644 bfs
'''
from collections import deque

n = int(input())
x,y = map(int,input().split())

m = int(input())

arr = [[] for i in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    idx,value = map(int,input().split())
    arr[idx].append(value)
    arr[value].append(idx)

def bfs(node):
    que = deque([node])
    while que:
        cur_node = que.popleft()
        for n in arr[cur_node]:
            if visited[n] == 0 :
                visited[n] = visited[cur_node] + 1
                que.append(n)
bfs(x)

print(visited[y] if visited[y]>0 else -1)