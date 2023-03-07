''' case1. use iterator
from sys import stdin
from itertools import combinations

while True:

    arr = list(map(int,stdin.readline().split()))
    k = arr[0]
    if k == 0:
        break
    s = arr[1:]

    combi = list(combinations(s,6))
    for item in combi:
        print(*list(item))
    print()

'''

'''
case2.not use iterator
'''

from sys import stdin

dp = [0 for i in range(13)]
def dfs(start,depth):
    if depth == 6:
        #6까지의 depth만 탐색
        print(*dp[:6])
        return
    for i in range(start,len(arr)):
        dp[depth] = arr[i]
        dfs(i+1,depth+1) # 이 부분이 핵심


while True:
    case = list(map(int,stdin.readline().split()))
    k = case[0]
    if k ==0:
        break

    arr = case[1:]
    dfs(0,0)
    print()






