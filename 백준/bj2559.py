'''
연속적인 날의 온도의 합
합배열 문제
'''
from sys import stdin

n,k = map(int,stdin.readline().split())

lst = list(map(int,stdin.readline().split()))

hap = sum(lst[:k])
hap_lst = [hap]

left,right = 0,k

for i in range(n-k):
    hap_lst.append(hap_lst[i]-lst[i]+lst[i+k])

print(max(hap_lst))