'''
같은 수를 여러번 골라도 된다
고른 수열은 비내림차순이어야한다 -> A1 <= A2 <= ... <= Ak-1 <= Ak

'''

from sys import stdin

n,m = map(int,stdin.readline().split())
arr = []

def DFS(start):
    if len(arr) == m:
        print(*arr)
        return

    for i in range(start,n+1):
        arr.append(i)
        DFS(i)
        arr.pop()

DFS(1)