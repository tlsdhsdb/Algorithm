'''
같은 수를 여러번 골라도 된다
'''
from sys import stdin

n,m = map(int,stdin.readline().split())
lst = sorted(list(map(int,stdin.readline().split())))
arr = []

def DFS():
    if len(arr) == m :
        print(*arr)
        return

    for i in range(len(lst)):
        arr.append(lst[i])
        DFS()
        arr.pop()


DFS()


