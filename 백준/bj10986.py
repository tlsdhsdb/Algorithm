from sys import stdin

n, m = map(int, stdin.readline().split())
num = list(map(int, stdin.readline().split()))

s = [0] * n
#합 배열
r = [0] * m
#나머지 배열

s[0] = num[0] #합배열의 첫번째는 고유배열의 첫번째 원소와 동일한 값을 가지고 있다.

answer = 0

for i in range(1,n):
    s[i] = s[i-1] + num[i]
    #합배열 만들기

for i in range(n):
    remainder = s[i] % m
    if remainder == 0 :
        answer += 1
    r[remainder] += 1

for i in range(m):
    if r[i]>1:
        answer += (r[i]*(r[i]-1)//2)

print(answer)