from collections import deque

n = int(input())

arr = []
answer = ""
for i in range(n):
    arr.append(deque(input()))

for idx in range(len(arr[0])):
    tmp = set()
    for i in range(n):
        tmp.add(arr[i].popleft())
    if len(tmp)==1:
        answer+= tmp.pop()
    else :
        answer+= "?"

print(answer)