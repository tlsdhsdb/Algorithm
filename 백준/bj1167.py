'''
bfs 1167 트리의 지름
트리의 지름 = 임의의 두 점 사이의 거리 중 가장 긴 것을 말함

임의의 노드 a와 가장 먼거리에 있는 노드 b를 찾고
b 노드와 가장 먼거리에 있는 c를 찾는다.
트리의 지름은 b - c 의 경로이다.

'''

from collections import deque

v = int(input())
graph = [[] for _ in range(v+1)]


for _ in range(v):
    tmp = list(int(i) for i in input().split())
    for i in range(1,len(tmp)- 2 ,2):
        graph[tmp[0]].append((tmp[i],tmp[i+1]))
    #그래프 저장


def bfs(start):
    visited = [-1] * (v+1) # 거리를 저장하는 배열
    que = deque() #순회하는 노드를 저장할 큐
    que.append(start)
    visited[start] = 0
    _max = (0,0) #가장 먼 노드를 저장 할 변수

    while que:
        t = que.popleft()
        for n,d in graph[t]:
            if visited[n] == -1:
                visited[n] = visited[t] + d # 현재 노드로부터 방문노드 사이의 거리를 저장함
                que.append(n)
                if _max[0] < visited[n]:
                    _max = visited[n], n
                    #거리가 크면 해당 노드를 저장함
    return _max


dis,node = bfs(1) # 임의의 노드에서 가장 먼 노드를 찾음
dis,node = bfs(node) # 가장 먼 노드 a와 가장 먼 노드를 찾음

print(dis)

