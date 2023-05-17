'''
이항 계수
'''
import math

n,k = map(int,input().split())

answer = 0

if k >= 0 and k <= n:
    answer = math.factorial(n) // (math.factorial(k) * math.factorial(n-k))


print(answer)