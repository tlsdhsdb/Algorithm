from collections import deque
from sys import stdin

n = int(input())
que = deque()

for _ in range(n):
    cmd = stdin.readline().split()

    if cmd[0] == 'pop_front':
        if que:
            print(que.popleft())
        else:
            print(-1)
    elif cmd[0] == 'pop_back':
        if que:
            print(que.pop())
        else:
            print(-1)
    elif cmd[0] == 'size':
        print(len(que))
    elif cmd[0] == 'empty':
        if que:
            print(0)
        else:
            print(1)
    elif cmd[0] == 'front':
        if que:
            print(que[0])
        else:
            print(-1)
    elif cmd[0] == 'back':
        if que:
            print(que[-1])
        else:
            print(-1)
    elif cmd[0] == 'push_front':
        que.appendleft(cmd[1])
    elif cmd[0] == 'push_back':
        que.append(cmd[1])