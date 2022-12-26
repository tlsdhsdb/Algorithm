from sys import stdin
from queue import PriorityQueue

N = int(stdin.readline())

que = PriorityQueue()

for _ in range(N):
    number = int(stdin.readline())
    if not que.empty():
        if number != 0:
            que.put((abs(number),number))
        else :
            print(que.get())
    else :
        print(0)
