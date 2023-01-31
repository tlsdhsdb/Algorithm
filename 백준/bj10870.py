'''
피보나치 수
0번째 0,
1번째 1,
2번째 0+1

n = 17 피보나치 수열
f17 = f16 + f15
f16 = f15 + f14
'''

from sys import stdin

def fibonacci(num):
    if num < 2 :
        if num == 1:
            return 1
        elif num == 0:
            return 0
    return fibonacci(num-1) + fibonacci(num-2)

n = int(stdin.readline())
print(fibonacci(n))