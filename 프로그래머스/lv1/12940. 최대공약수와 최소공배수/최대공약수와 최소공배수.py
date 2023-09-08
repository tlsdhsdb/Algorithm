import math

def solution(n,m):
    g = 0
    l = 0

    g= math.gcd(n,m)
    l = n * m // g

    answer = [g,l]
    return answer
    