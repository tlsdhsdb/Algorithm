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





