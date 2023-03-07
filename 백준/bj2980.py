from sys import stdin
from collections import deque

t,l = map(int,stdin.readline().split())
lst = deque()
timer = 0
distance = 0
traffic = []

for _ in range(t):
    lst.append(list(map(int,stdin.readline().split())))

while distance < l:
    if lst and not traffic:
        traffic = lst.popleft()
    if traffic:
        if distance == traffic[0]:
            if timer % (traffic[1]+traffic[2]) >= traffic[1]:
                traffic = []
                distance += 1
        else:
            distance += 1
    else :
        distance += 1

    timer += 1

print(timer)
