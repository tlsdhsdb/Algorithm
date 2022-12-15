from collections import deque
from sys import stdin

N,L = map(int,stdin.readline().split())

arr = list(map(int,stdin.readline().split()))

que = deque()

answer = []

for i in range(N):
    while que and que[-1][0] > arr[i]:
        que.pop()
    while que and que[0][1] < i-L+1:
        que.popleft()
    que.append((arr[i],i))
    print(que[0][0],end=" ")
    print(type(que[0]))

