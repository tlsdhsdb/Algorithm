'''
항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱해서 곱한다음 더함

'''
import math

l = int(input())
st = list(input())

answer = 0

for i in range(l):
    num = ord(st[i]) - 96
    answer += num * (31 ** i)

print(answer%1234567891)

