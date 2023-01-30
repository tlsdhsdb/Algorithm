from sys import stdin

import math


def isPrimeNumber(number):
    if number == 1:
        return False;
    for i in range(2, int(math.sqrt(number)) + 1):
        # x가 해당 수로 나누어떨어진다면
        if number % i == 0:
            return False  # 소수가 아님
    return True  # 소수임

def dfs(number):
    global answer
    global N
    if number < math.pow(10,N) and number > math.pow(10,N-1):
        answer.append(number)

    for i in range(1,10,2):
        tmp = (number*10)+i
        if isPrimeNumber(tmp) == True:
            dfs(tmp)

N = int(stdin.readline())
answer = []

for i in range(1,9):
    if isPrimeNumber(i) == True:
        dfs(i)


answer = sorted(answer)

for i in answer:
    print(i)

