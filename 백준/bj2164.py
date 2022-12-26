
from sys import stdin
from collections import deque

N = int(stdin.readline())

que = deque()

for i in range(N):
    que.append(i+1)


while len(que) > 1:
    que.popleft()
    front = que.popleft()
    que.append(front)

print(que.popleft())