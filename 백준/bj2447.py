import sys
from sys import stdin
sys.setrecursionlimit(10**6)
## recursion limit 설정

def draw_star(n):
    if n == 1:
        return ['*']

    stars = draw_star(n//3)
    #1이 되면 *를 리턴받고 * 부터 시작한다
    arr = []

    # loop 에서 draw_star(3)으로 시작한다
    # 기본별을 시작으로 거기에서 증가시켜나감
    # ***
    # * *
    # ***
    for star in stars:
        arr.append(star*3)
    for star in stars:
        arr.append(star+' '*(n//3)+star)
    for star in stars:
        arr.append(star*3)

    return arr

n = int(stdin.readline())
arr = draw_star(n)
print('\n'.join(arr))

# 참고할 풀이
# 이 사람들은 왜 속도가 이렇게 빠른가 ? 어떤식으로 풀었나 분석 필요!
# https://www.acmicpc.net/source/52432350
# https://www.acmicpc.net/source/54931050
# https://www.acmicpc.net/source/54837455