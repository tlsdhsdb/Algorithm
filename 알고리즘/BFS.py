from collections import deque
def bfs(que):
    global arr
    if not que:
        return
    node = que.popleft()
    visited[node] = True
    for i in arr[node]:
        if visited[i] == False:
            que.append(i)
    bfs(que)

arr =  [[],[2,3],[5,6],[4],[6],[],[]]
visited = [False] * (len(arr)+1)

start_node = 1

que = deque([start_node])

bfs(que)
