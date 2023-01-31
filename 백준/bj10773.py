#가장 최근에 쓴 수를 지우게 하자
#입력이 100,000번

from sys import stdin

n = int(stdin.readline())

stack = []
for _ in range(n):
    num = int(stdin.readline())
    if num != 0:
        stack.append(num)
    else:
        stack.pop()

print(sum(stack))