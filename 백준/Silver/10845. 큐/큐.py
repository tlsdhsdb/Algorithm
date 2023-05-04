'''
백준 10845
큐 구현하기
'''
from collections import deque
from sys import stdin


n = int(input())

arr = deque()

for i in range(n):
    value = stdin.readline().split()

    if value[0] == 'push':
        arr.append(value[1])
    elif value[0] == 'pop':
        if len(arr) != 0:
            print(arr.popleft())
        else:
            print(-1)
    elif value[0] == 'size':
        print(len(arr))
    elif value[0] == 'front':
        if len(arr) != 0:
            print(arr[0])
        else:
            print(-1)
    elif value[0] == 'back':
        if len(arr) != 0:
            print(arr[-1])
        else:
            print(-1)
    elif value[0] == 'empty':
        if arr:
            print(0)
        else:
            print(1)
