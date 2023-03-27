'''
바이러스
주어진 노드와 연결된 노드의 개수를 구하는 문제
방문한 노드에 1표시를 하면 연결된 노드의 개수가 나옴,본인 자신도 체크되기 때문에 1을 빼준다
'''

from collections import deque

n = int(input())
m = int(input())

tree = [[] for i in range(n+1)]
visited = [0] * (n + 1)

for i in range(m):
    idx,value = map(int,input().split())
    tree[idx].append(value)
    tree[value].append(idx)

def bfs(node):
    que = deque([node])
    while que:
        cur_node = que.popleft()

        for n in tree[cur_node]:
            if visited[n] == 0:
                que.append(n)
                visited[n] = 1

bfs(1)
print(sum(visited)-1)
