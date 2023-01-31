from sys import stdin

#재귀함수로 구현

def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n-1)


num = int(stdin.readline())
if num == 0:
    print(1)
else :
    print(factorial(num))

'''
5 * 4 * 3 * 2 * 1
'''
