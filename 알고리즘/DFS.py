## dfs 깊이 우선 탐색 알고리즘
## 재귀를 사용하여 구현
def dfs(node):
    global arr
    visited[node] = True
    for i in arr[node] :
        if visited[i] == False:
            dfs(i)


arr =  [[],[2,3],[5,6],[4],[6],[],[]]
visited = [False] * (len(arr)+1)

start_node = 1

dfs(start_node)
